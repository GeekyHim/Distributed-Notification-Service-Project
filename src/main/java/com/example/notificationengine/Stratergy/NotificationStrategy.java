package com.example.notificationengine.Stratergy;

import com.example.notificationengine.Model.NotificationRequest;

public interface NotificationStrategy {
    void send(NotificationRequest request);
}