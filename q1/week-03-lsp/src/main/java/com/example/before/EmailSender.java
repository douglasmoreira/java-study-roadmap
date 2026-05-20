package com.example.before;

import com.example.before.sender.SmtpClient;

public class EmailSender extends NotificationSender {
    @Override
    public void send(String recipient, String message) {
        SmtpClient client = new SmtpClient();
        client.send(recipient, message);
    }
}
