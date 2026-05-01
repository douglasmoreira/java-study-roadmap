package com.example.after;

public class UserService {

        private final PasswordEncryptor passwordEncryptor;
        private final UserRepository userRepository;
        private final EmailSender emailSender;
        private final UserValidator  userValidator;

        public UserService(
                PasswordEncryptor passwordEncryptor,
                UserRepository userRepository,
                EmailSender emailSender,
                UserValidator userValidator) {
            this.passwordEncryptor = passwordEncryptor;
            this.userRepository = userRepository;
            this.emailSender = emailSender;
            this.userValidator = userValidator;
        }

        public void registerUser(String name, String email, String rawPassword) {
            // Validate input
            userValidator.validateUser(name, email, rawPassword);

            // Hash password
            String hashedPassword = passwordEncryptor.encryptPassword(rawPassword);

            // Save user to database
            userRepository.save(name, email, hashedPassword);

            // Send welcome email
            emailSender.send(email, name);
        }
    }

