package com.example.before;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderNotificationServiceBefore {

    private static final Logger log =
            LoggerFactory.getLogger(OrderNotificationServiceBefore.class);

    public void notify(String channel, String message) {
        if (channel.equals("EMAIL")) {
            log.info("[EMAIL] Sending email: {}", message);
            // imagine real email logic here
        } else if (channel.equals("SMS")) {
            log.info("[SMS] Sending SMS: {}", message);
            // imagine real SMS logic here
        } else if (channel.equals("PUSH")) {
            log.info("[PUSH] Sending push notification: {}", message);
            // imagine real push logic here
        } else {
            log.warn("Unknown channel: {}", channel);
        }
    }
}
