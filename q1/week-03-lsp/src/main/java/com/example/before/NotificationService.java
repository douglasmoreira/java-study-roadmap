package com.example.before;

import java.util.List;

public class NotificationService {
    private final List<NotificationSender> senders;

    public NotificationService(List<NotificationSender> senders) {
        this.senders = senders;
    }

    public void notifyAll(String recipient, String message) {
        for (NotificationSender sender : senders) {
            sender.send(recipient, message);
        }
    }
}