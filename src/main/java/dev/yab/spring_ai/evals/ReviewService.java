package dev.yab.spring_ai.evals;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.stereotype.Service;

/**
 * @author HP
 **/
@Service
public class ReviewService {
    private final ChatClient chatClient;

    public ReviewService(ChatClient.Builder builder) {
        this.chatClient = builder
                .defaultOptions(OpenAiChatOptions.builder().temperature(0.1d).build())
                .build();
    }

    public SentimentResponse classifySentiment(String review) {
        String systemPrompt = """
        Classify the sentiment of the following text as POSITIVE, NEGATIVE, or NEUTRAL.
        Respond using JSON like this: { "sentiment": "POSITIVE" }""";

        return chatClient.prompt()
                .system(systemPrompt)
                .user(review)
                .call()
                .entity(SentimentResponse.class);
    }

}
