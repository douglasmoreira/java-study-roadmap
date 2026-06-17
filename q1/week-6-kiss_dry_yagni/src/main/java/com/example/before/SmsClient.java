package com.example.before;

public class SmsClient {

    public void send(String phone, String message) {
        System.out.println("SMS -> " + phone + ": " + message);
    }
}
