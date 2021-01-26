package me.www.websocket.config;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.lang.Nullable;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import java.util.Map;

/**
 * <websocket通讯拦截器>
 * <建立websocket连接前后的业务处理>
 */
public class TaskHandshakeInterceptor extends HttpSessionHandshakeInterceptor {

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response,
                                   WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        if (request instanceof ServletServerHttpRequest) {
            ServletServerHttpRequest serverHttpRequest = (ServletServerHttpRequest) request;
            // 获取请求路径携带的参数
            String userName = serverHttpRequest.getServletRequest().getParameter("userName");
            attributes.put("userName", userName);
            String taskId = serverHttpRequest.getServletRequest().getParameter("taskId");
            attributes.put("taskId", taskId);
            // 调用父类方法
            return super.beforeHandshake(request, response, wsHandler, attributes);
        } else {
            return false;
        }
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response,
                               WebSocketHandler wsHandler, @Nullable Exception ex) {
        // websocket握手建立后调用
        System.out.println("websocket连接握手成功");
    }

}
