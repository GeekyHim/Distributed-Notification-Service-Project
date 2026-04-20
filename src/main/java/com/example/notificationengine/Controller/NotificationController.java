package com.example.notificationengine.Controller;

import com.example.notificationengine.Model.NotificationRequest;
import com.example.notificationengine.Service.NotificationProducer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/notifications")
public class NotificationController {

    private final NotificationProducer producer;

    public NotificationController(NotificationProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/send")
    public String sendNotification(@RequestBody NotificationRequest request) {
        try {
            producer.sendMessage(request);
            return "Notification queued!";
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }
}