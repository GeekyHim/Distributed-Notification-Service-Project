package com.example.notificationengine.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationRequest {
    private String userId;
    private String message;
    private String channel; // "EMAIL", "SMS", "PUSH"
    private String recipient;
}