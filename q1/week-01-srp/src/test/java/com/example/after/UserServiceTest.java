package com.example.after;

import org.junit.jupiter.api.Test;

class UserServiceTest {

    @Test
    public void testUserService() {
        EmailSender emailSender = new EmailSender();
        UserRepository userRepository = new UserRepository();
        PasswordEncryptor passwordEncryptor = new PasswordEncryptor();
        UserValidator  userValidator = new UserValidator();

        UserService service = new UserService(passwordEncryptor, userRepository, emailSender, userValidator);

        service.registerUser("name", "email@email", "hashedPassword");
    }
  
}