package com.example.after;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PushNotificationChannel implements NotificationChannel {
    private static final Logger log =
            LoggerFactory.getLogger(PushNotificationChannel.class);

    @Override
    public void notify(String message) {
        log.info("[PUSH] Sending push notification: {}", message);
    }
}
