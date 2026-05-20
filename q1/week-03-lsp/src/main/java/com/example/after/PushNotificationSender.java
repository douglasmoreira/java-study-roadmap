package com.example.after;

import com.example.after.sender.PushGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PushNotificationSender extends NotificationSender {
    private static final Logger logger = LoggerFactory.getLogger(PushNotificationSender.class);

    @Override
    public void send(String recipient, String message) {
        if (message.length() > 100) {
            logger.warn("Push notification skipped for recipient '{}' — message length {} exceeds 100-character limit",
                    recipient, message.length());
            return;
        }
        PushGateway gateway = new PushGateway();
        gateway.push(recipient, message);
    }
}