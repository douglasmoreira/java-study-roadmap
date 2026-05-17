package com.example.after;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmailNotificationChannel implements NotificationChannel {
    private static final Logger log =
            LoggerFactory.getLogger(EmailNotificationChannel.class);

    @Override
    public void notify(String message) {
        log.info("[EMAIL] Sending email: {}", message);
    }
}
