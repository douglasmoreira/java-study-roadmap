package com.example.before;

public abstract class NotificationSender {
    /**
     * Sends a notification to the given recipient.
     * Always completes without throwing — delivery failures
     * are handled internally and logged.
     * @param recipient non-null recipient identifier
     * @param message   non-null message body
     */
    public abstract void send(String recipient, String message);
}
