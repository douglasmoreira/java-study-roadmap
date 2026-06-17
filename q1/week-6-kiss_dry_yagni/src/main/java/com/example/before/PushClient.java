package com.example.before;

public class PushClient {

    public void send(String deviceId, String message) {
        System.out.println("PUSH -> " + deviceId + ": " + message);
    }
}
