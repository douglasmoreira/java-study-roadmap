package com.example.after;

import com.example.after.adapter.CardPaymentAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CardPaymentAdapterTest {
    private CardPaymentAdapter cardPaymentAdapter;

    @BeforeEach
    void setUp() {
        cardPaymentAdapter = new CardPaymentAdapter();
    }

    @Test
    public void processPaymentSuccessfully() {
        assertDoesNotThrow(() ->
                cardPaymentAdapter.processCardPayment("token123", BigDecimal.valueOf(100)));
    }

    @Test
    public void getPaymentStatusSuccessfully() {
        assertDoesNotThrow(() ->
                cardPaymentAdapter.getCardPaymentStatus("token123"));
    }

    @Test
    public void refundCardPaymentSuccessfully() {
        assertDoesNotThrow(() ->
                cardPaymentAdapter.refundCardPayment("token123", BigDecimal.valueOf(100)));
    }
}