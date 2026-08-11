package org.example;

import org.example.messager.EmailClient;
import org.example.messager.PushClient;
import org.example.messager.SmsClient;

public class NotificationServiceBefore {

    private EmailClient emailClient;
    private SmsClient smsClient;
    private PushClient pushClient;

    public NotificationServiceBefore(EmailClient emailClient, SmsClient smsClient, PushClient pushClient) {
        this.emailClient = emailClient;
        this.smsClient = smsClient;
        this.pushClient = pushClient;
    }

    public boolean proc(String uid, String msg, int t, boolean f, boolean log) {
        boolean ok = false;
        String x = "";

        if (t == 1) {
            x = "Dear customer, " + msg;
            ok = emailClient.send(uid, x);
        } else if (t == 2) {
            x = msg.length() > 160 ? msg.substring(0, 160) : msg;
            ok = smsClient.send(uid, x);
        } else if (t == 3) {
            x = msg;
            ok = pushClient.send(uid, x);
        }

        if (f) {
            if (t == 1) {
                x = "URGENT: " + msg;
            }
            ok = emailClient.send(uid, x);
        }

        if (log) {
            System.out.println("Notification sent to " + uid + ": " + ok);
        }

        return ok;
    }
}