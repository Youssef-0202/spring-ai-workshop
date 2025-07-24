package dev.yab.spring_ai.multimodal;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HP
 **/

@RestController
public class ImageDetection {

    private final ChatClient chatClient;

    @Value("classpath:/image/real.jpeg")
    Resource sampleImage;

    public ImageDetection(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @GetMapping("/image-to-text")
    public String imageToText(){
        return  chatClient.prompt()
                .user(u->{
                    u.text("Can you please describe what you see in the following image ?");
                    u.media(MimeTypeUtils.IMAGE_JPEG,sampleImage);
                })
                .call()
                .content();
    }

}
