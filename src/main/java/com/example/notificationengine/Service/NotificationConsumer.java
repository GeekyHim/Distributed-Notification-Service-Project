package com.example.notificationengine.Service;

import com.example.notificationengine.Model.NotificationRequest;
import com.example.notificationengine.Stratergy.NotificationStrategy;
import com.example.notificationengine.Stratergy.NotificationStrategyFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

    private final NotificationStrategyFactory strategyFactory;

    public NotificationConsumer(NotificationStrategyFactory strategyFactory) {
        this.strategyFactory = strategyFactory;
    }

    @KafkaListener(topics = "notification-topic", groupId = "notification-group")
    public void consume(NotificationRequest request) {

        System.out.println("\nConsumer: Received message from Kafka");

        // simulating failure
        if (request.getMessage().contains("fail")) {
            throw new RuntimeException("Simulated failure!");
        }

        NotificationStrategy strategy =
                strategyFactory.getStrategy(request.getChannel());

        strategy.send(request);
    }
}