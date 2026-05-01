package com.example.after;

import org.mindrot.jbcrypt.BCrypt;

public class UserServiceBefore {


    public void registerUser(String name, String email, String rawPassword) {
        // Validate input
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name is required");
        }
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email");
        }
        if (rawPassword == null || rawPassword.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters");
        }

        // Hash password
        String hashedPassword = BCrypt.hashpw(rawPassword, BCrypt.gensalt());

        // Save user to database
        String sql = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
        System.out.println("Executing: " + sql);
        System.out.println("Saved user: " + name + " | " + email + " | " + hashedPassword);

        // Send welcome email
        System.out.println("Sending welcome email to: " + email);
        System.out.println("Subject: Welcome, " + name + "!");
    }
}
