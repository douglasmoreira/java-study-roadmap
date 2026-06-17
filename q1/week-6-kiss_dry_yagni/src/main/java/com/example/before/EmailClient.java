package com.example.before;

public class EmailClient {

    public void send(String email, String subject, String message) {
        System.out.println("EMAIL");
        System.out.println("To: " + email);
        System.out.println("Subject: " + subject);
        System.out.println("Message: " + message);
    }
}
