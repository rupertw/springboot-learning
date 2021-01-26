package me.www.websocket.config;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.PongMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * <消息处理中心>
 * <功能详细描述>
 **/
@Component
public class TaskWebSocketHandler extends AbstractWebSocketHandler {

    private final static Map<String, List<WebSocketSession>> sessionMap = new ConcurrentHashMap();


    // 服务器与客户端初次websocket连接成功执行
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        String taskId = getTaskId(session);
        System.out.println("建立连接：" + getUserName(session) + " - " + taskId);
        if (!StringUtils.isEmpty(taskId)) {
            if (sessionMap.containsKey(taskId)) {
                sessionMap.get(taskId).add(session);
            } else {
                List<WebSocketSession> sessions = new CopyOnWriteArrayList();
                sessions.add(session);
                sessionMap.put(taskId, sessions);
            }
        }
    }

    // 接受消息处理消息
    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        /*
        获取客户端发送的消息,这里使用文件消息，也就是字符串进行接收
        消息可以通过字符串，或者字节流进行接收
        TextMessage String/byte[]接收均可以
        BinaryMessage byte[]接收
        */
        if (message instanceof TextMessage) {
            String text = new String(((TextMessage) message).asBytes());
            System.out.println("客户端发送消息：" + getUserName(session) + " - " + text);
        } else if (message instanceof BinaryMessage) {

        } else if (message instanceof PongMessage) {

        } else {
            System.out.println("Unexpected WebSocket message type: " + message);
        }
    }

    // Handle an error from the underlying WebSocket message transport.
    @Override
    public void handleTransportError(WebSocketSession session, Throwable throwable) throws Exception {
        if (session.isOpen()) {
            System.out.println("客户端消息传输错误：" + getUserName(session));
            session.close();
            List<WebSocketSession> sessions = sessionMap.get(getTaskId(session));
            if (!sessions.isEmpty()) {
                sessions.remove(session);
            }
        }
    }

    // 关闭websocket时触发
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        System.out.println("客户端关闭连接：" + getUserName(session));
        String taskId = getTaskId(session);
        if (!StringUtils.isEmpty(taskId)) {
            List<WebSocketSession> sessions = sessionMap.get(taskId);
            for (WebSocketSession ws : sessions) {
                if (!ws.isOpen()) {
                    sessions.remove(ws);
                }
            }
        }
    }

    public void sendMessage(String taskId, String message) {
        TextMessage textMessage = new TextMessage(message.getBytes(StandardCharsets.UTF_8));
        sendMessage(taskId, textMessage);
    }

    /**
     * 给所有在线用户发送消息（这里用的文本消息）
     *
     * @param message
     */
    public void sendMessage(String taskId, TextMessage message) {
        List<WebSocketSession> sessions = sessionMap.get(taskId);
        if (sessions != null) {
            for (WebSocketSession session : sessions) {
                try {
                    session.sendMessage(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getTaskId(WebSocketSession session) {
        return (String) session.getAttributes().get("taskId");
    }

    public String getUserName(WebSocketSession session) {
        return (String) session.getAttributes().get("userName");
    }

}
