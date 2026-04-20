package com.example.notificationengine.Stratergy;

import com.example.notificationengine.Model.NotificationRequest;
import org.springframework.stereotype.Component;

@Component("EMAIL")
public class EmailNotificationStrategy implements NotificationStrategy {

    @Override
    public void send(NotificationRequest request) {
        System.out.println("Sending EMAIL to: " + request.getRecipient());
        System.out.println("Message: " + request.getMessage());
    }
}