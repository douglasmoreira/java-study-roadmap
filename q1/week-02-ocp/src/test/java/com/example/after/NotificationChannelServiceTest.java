package com.example.after;

import org.junit.jupiter.api.Test;

import java.util.List;

class NotificationChannelServiceTest {

    @Test
    void notifyTest() {
        EmailNotificationChannel emailNotification = new EmailNotificationChannel();
        List<NotificationChannel> channels = List.of(emailNotification);

        OrderNotificationService service = new OrderNotificationService(channels);

        service.notify("Email Notification");
    }
}