package com.example.before;

public class Customer {

    private String id;
    private String email;
    private boolean active;
    private boolean blacklisted;
    private Preferences preferences;

    public Customer(String id, String email) {
        this.id = id;
        this.email = email;
        this.active = true;
        this.blacklisted = false;
        this.preferences = new Preferences();
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public boolean isActive() {
        return active;
    }

    public boolean isBlacklisted() {
        return blacklisted;
    }

    public boolean hasEmail() {
        return email != null && !email.isBlank();
    }

    public Preferences getPreferences() {
        return preferences;
    }
}
