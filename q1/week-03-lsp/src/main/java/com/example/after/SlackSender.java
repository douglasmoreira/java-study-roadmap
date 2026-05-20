package com.example.after;

import com.example.after.sender.SlackClient;

public class SlackSender extends NotificationSender {
    @Override
    public void send(String recipient, String message) {
        SlackClient client = new SlackClient();
        client.postMessage(recipient, message);
    }
}