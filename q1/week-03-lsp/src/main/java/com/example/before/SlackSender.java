package com.example.before;

import com.example.before.sender.SlackClient;

public class SlackSender extends NotificationSender {
    @Override
    public void send(String recipient, String message) {
        SlackClient client = new SlackClient();
        client.postMessage(recipient, message);
    }
}