package dev.yab.spring_ai.prompt;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HP
 **/

@RestController
@RequestMapping("/team-inf")
public class TeamsInfoController {


    private final ChatClient chatClient;

    public TeamsInfoController(ChatClient.Builder builder){
        this.chatClient  = builder.build();
    }

    @GetMapping("/chat")
    public String chat(@RequestParam String message){

        var systemInstruction = """
        You are a helpful and knowledgeable assistant specialized only in the English Premier League (EPL).

        If the user's question is about the EPL—teams, players, history, stats, standings, match results, or transfers—answer clearly and factually.

        If the user's question is outside the scope of the EPL (e.g., La Liga, Serie A, NBA, politics, general topics, celebrities, etc.), politely reply:
        "I'm specialized in the English Premier League. Please ask a question related to it."

        Always stay focused on the EPL, and never make up answers about unrelated topics.
        """;

        return chatClient.prompt()
                .user(message)
                .system(systemInstruction)
                .call()
                .content();
    }


}
