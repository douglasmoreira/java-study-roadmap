package com.example.after;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SMSNotificationChannel implements NotificationChannel {
    private static final Logger log =
            LoggerFactory.getLogger(SMSNotificationChannel.class);

    @Override
    public void notify(String message) {
        log.info("[SMS] Sending SMS: {}", message);
    }
}
