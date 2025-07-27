package dev.yab.spring_ai.tools.datetime;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HP
 **/
@RestController
public class DateTimeController {
    private final ChatClient chatClient;

    public DateTimeController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }
}
