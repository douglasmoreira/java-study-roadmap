package com.example.after;

import java.util.List;

public class OrderNotificationService {

    private final List<NotificationChannel> channels;

    public OrderNotificationService(List<NotificationChannel> channels) {
        this.channels = channels;
    }

    public void notify(String message) {
        channels.forEach(c -> c.notify(message));
    }
}
