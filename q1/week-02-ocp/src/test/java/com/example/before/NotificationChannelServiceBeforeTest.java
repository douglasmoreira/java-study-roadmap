package com.example.before;

import com.example.after.OrderNotificationService;
import org.junit.jupiter.api.Test;

class NotificationChannelServiceBeforeTest {

    @Test
    public void notifyTest() {
        OrderNotificationServiceBefore service = new OrderNotificationServiceBefore();

        service.notify("EMAIL", "Email Notification");
    }

}