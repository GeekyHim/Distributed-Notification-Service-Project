package com.example.notificationengine.Service;

import com.example.notificationengine.Model.NotificationRequest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationProducer {

    private static final String TOPIC = "notification-topic";
    private final KafkaTemplate<String, NotificationRequest> kafkaTemplate;
    private final RateLimiterService rateLimiter;

    public NotificationProducer(KafkaTemplate<String, NotificationRequest> kafkaTemplate,
                                RateLimiterService rateLimiter) {
        this.kafkaTemplate = kafkaTemplate;
        this.rateLimiter = rateLimiter;
    }

    public void sendMessage(NotificationRequest request) {

        if (!rateLimiter.isAllowed(request.getUserId())) {
            throw new RuntimeException("Rate limit exceeded for user: " + request.getUserId());
        }

        kafkaTemplate.send(TOPIC, request);
        System.out.println("Producer: Sent message to Kafka Topic: " + request.getMessage());
    }
}