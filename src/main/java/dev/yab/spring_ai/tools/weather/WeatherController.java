package dev.yab.spring_ai.tools.weather;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HP
 **/
@RestController
public class WeatherController {
    private final ChatClient chatClient;
    private final WeatherTools weatherTools;

    public WeatherController(ChatClient.Builder builder, WeatherTools weatherTools) {
        this.chatClient = builder.build();
        this.weatherTools = weatherTools;
    }

    @GetMapping("/weather/alerts")
    public String getAlerts(@RequestParam String message) {
        return chatClient.prompt()
                .tools(weatherTools)
                .user(message)
                .call()
                .content();
    }
}
