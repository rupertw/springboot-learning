package me.www.websocket.controller;

import me.www.websocket.config.TaskWebSocketHandler;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/task")
public class TaskController {

    private final TaskWebSocketHandler taskWebSocketHandler;

    public TaskController(TaskWebSocketHandler taskWebSocketHandler) {
        this.taskWebSocketHandler = taskWebSocketHandler;
    }

    // 测试私信发送
    // localhost:8080/task/sendMessage?taskId=1&message=发送消息5
    @PostMapping(value = "/sendMessage")
    @ResponseBody
    public Boolean sendMessage(String taskId, String message) {
        if (StringUtils.isEmpty(taskId) || StringUtils.isEmpty(message)) {
            return false;
        }
        taskWebSocketHandler.sendMessage(taskId, message);
        return true;
    }

}