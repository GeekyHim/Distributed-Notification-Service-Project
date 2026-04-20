package com.example.notificationengine.Stratergy;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class NotificationStrategyFactory {

    private final Map<String, NotificationStrategy> strategyMap;

    public NotificationStrategyFactory(Map<String, NotificationStrategy> strategyMap) {
        this.strategyMap = strategyMap;
    }

    public NotificationStrategy getStrategy(String channel) {
        NotificationStrategy strategy = strategyMap.get(channel);

        if (strategy == null) {
            throw new IllegalArgumentException("Invalid channel: " + channel);
        }

        return strategy;
    }
}