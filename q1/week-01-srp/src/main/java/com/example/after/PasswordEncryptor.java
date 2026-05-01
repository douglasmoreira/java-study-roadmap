package com.example.after;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordEncryptor {

    public String encryptPassword(String rawPassword) {
        return BCrypt.hashpw(rawPassword, BCrypt.gensalt());
    }
}
