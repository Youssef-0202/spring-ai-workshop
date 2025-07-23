package dev.yab.spring_ai;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringAiWorkshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAiWorkshopApplication.class, args);
	}

//	@Bean
//	public ChatClient openAiChatClient(OpenAiChatModel chatModel){
//		return ChatClient.create(chatModel);
//	}
//
//
//	@Bean
//	public ChatClient anthropicChatClient(AnthropicChatModel  chatModel){
//		return ChatClient.create(chatModel);
//	}

}
