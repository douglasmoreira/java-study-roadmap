package com.example.before;

import com.example.before.sender.PushGateway;

public class PushNotificationSender extends NotificationSender {
    @Override
    public void send(String recipient, String message) {
        if (message.length() > 100) {
            throw new IllegalArgumentException(
                    "Push notifications cannot exceed 100 characters"
            );
        }
        PushGateway gateway = new PushGateway();
        gateway.push(recipient, message);
    }
}