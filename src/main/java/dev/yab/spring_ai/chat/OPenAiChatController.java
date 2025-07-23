package dev.yab.spring_ai.chat;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @author HP
 **/
@RestController
@RequestMapping("/openai")
public class OPenAiChatController {
    private final ChatClient chatClient;

    public OPenAiChatController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

//    public OPenAiChatController(@Qualifier("openAiChatClient") ChatClient chatClient) {
//        this.chatClient = chatClient;
//    }

    @GetMapping("/chat")
    public String chat(){
        return chatClient.prompt()
                .user("Tell me about interesting thing about marrakech !")
                .call()
                .content();
    }

    @GetMapping("/stream")
    public Flux<String> stream(){
        return chatClient.prompt()
                .user("i am visiting Rome , can you give me 10 info about this city ? ")
                .stream()
                .content();
    }

    @GetMapping("/joke")
    public ChatResponse joke(){
        return chatClient.prompt()
                .user("Tell me a bad joke")
                .call()
                .chatResponse();
    }

}
