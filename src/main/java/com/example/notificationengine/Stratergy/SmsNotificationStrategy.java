package com.example.notificationengine.Stratergy;

import com.example.notificationengine.Model.NotificationRequest;
import org.springframework.stereotype.Component;

@Component("SMS")
public class SmsNotificationStrategy implements NotificationStrategy {

    @Override
    public void send(NotificationRequest request) {
        System.out.println("📱 Sending SMS to: " + request.getRecipient());
        System.out.println("Message: " + request.getMessage());
    }
}