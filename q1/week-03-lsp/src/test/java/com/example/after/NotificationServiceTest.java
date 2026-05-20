package com.example.after;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class NotificationServiceTest {
    private NotificationService service;

    @BeforeEach
    void setUp() {
        List<NotificationSender> senderList = List.of(new EmailSender(), new PushNotificationSender(), new SlackSender());
        service = new  NotificationService(senderList);
    }

    @Test
    void testNotifyAll() {
        String logMessage = "message".repeat(200);

        assertDoesNotThrow(() -> service.notifyAll("recipes", logMessage));
    }

    @Test
    void shouldNotThrowWhenPushMessageExceedsLimit() {
        NotificationService service = new NotificationService(
                List.of(new PushNotificationSender())
        );

        String longMessage = "a".repeat(200);

        assertDoesNotThrow(() -> service.notifyAll("user@example.com", longMessage));
    }
}