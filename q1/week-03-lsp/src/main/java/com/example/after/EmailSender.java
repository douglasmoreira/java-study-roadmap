package com.example.after;

import com.example.after.sender.SmtpClient;

public class EmailSender extends NotificationSender {
    @Override
    public void send(String recipient, String message) {
        SmtpClient client = new SmtpClient();
        client.send(recipient, message);
    }
}
