package dev.yab.spring_ai.tools.action;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HP
 **/
@RestController
public class TaskManagementController {
    private final ChatClient chatClient;
    private final TaskManagementTools tools;

    public TaskManagementController(ChatClient.Builder builder, TaskManagementTools tools) {
        this.chatClient = builder.build();
        this.tools = tools;
    }

    @GetMapping("/tasks")
    public String createTask(@RequestParam String message) {
        return chatClient.prompt()
                .tools(tools    )
                .user(message)
                .call()
                .content();
    }
}
