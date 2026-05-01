package com.example.after;

public class EmailSender {

    public void send(String email, String name) {
        System.out.println("Sending welcome email to: " + email);
        System.out.println("Subject: Welcome, " + name + "!");
    }
}
