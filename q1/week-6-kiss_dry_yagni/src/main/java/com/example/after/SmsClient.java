package com.example.after;

public class SmsClient {

    public void send(String phone, String message) {
        System.out.println("SMS -> " + phone + ": " + message);
    }
}
