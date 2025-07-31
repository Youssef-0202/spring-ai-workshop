package dev.yab.spring_ai.evals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author HP
 **/
@SpringBootTest
public class SentimentAnalysisTest {
    @Autowired
    ReviewService service;


    @Test
    void testPositiveSentiment() {
        // Given
        String positiveReview = "Wow, that was really good!";

        // When
        SentimentResponse response = service.classifySentiment(positiveReview);

        // Then
        assertEquals(Sentiment.POSITIVE, response.getSentiment(), "The sentiment should be classified as positive!");
    }
}
