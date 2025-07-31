package dev.yab.spring_ai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @author HP
 **/
@TestConfiguration
public class ChatClientTestConfig {

    @Bean
    ChatClient chatClient(ChatClient.Builder builder){
        return builder.build();
    }
}
