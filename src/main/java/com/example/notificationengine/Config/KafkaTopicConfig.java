package com.example.notificationengine.Config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic mainTopic() {
        return new NewTopic("notification-topic", 1, (short) 1);
    }

    @Bean
    public NewTopic dlqTopic() {
        return new NewTopic("notification-dlq", 1, (short) 1);
    }
}