package com.example.after;

public class UserRepository {

    public void save(String name, String email, String hashedPassword) {
        String sql = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
        System.out.println("Executing: " + sql);
        System.out.println("Saved user: " + name + " | " + email + " | " + hashedPassword);
    }
}
