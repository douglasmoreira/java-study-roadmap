package org.example;

import org.example.messager.EmailClient;
import org.example.messager.PushClient;
import org.example.messager.SmsClient;

public class NotificationService {

    private EmailClient emailClient;
    private SmsClient smsClient;
    private PushClient pushClient;

    public NotificationService(EmailClient emailClient, SmsClient smsClient, PushClient pushClient) {
        this.emailClient = emailClient;
        this.smsClient = smsClient;
        this.pushClient = pushClient;
    }

    public boolean sendMessage(String userId, String message, NotificationType notificationType) {
        String formattedMessage;

        boolean notificationSent =
                switch (notificationType) {
                    case EMAIL -> {
                        formattedMessage = "Dear customer, " + message;
                        yield emailClient.send(userId, formattedMessage);
                    }
                    case SMS -> {
                        formattedMessage = message.length() > 160 ? message.substring(0, 160) : message;
                        yield smsClient.send(userId, formattedMessage);
                    }
                    case PUSH -> {
                        formattedMessage = message;
                        yield pushClient.send(userId, formattedMessage);
                    }
                };

        System.out.println("Notification sent to " + userId + ": " + notificationSent);
        return notificationSent;
    }

    public boolean sendPriorityEmail(String userId, String message) {
        String formattedMessage = "URGENT: " + message;
        boolean notificationSent = emailClient.send(userId, formattedMessage);

        System.out.println("Notification sent to " + userId + ": " + notificationSent);
        return notificationSent;
    }
}