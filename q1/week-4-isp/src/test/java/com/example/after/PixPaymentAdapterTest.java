package com.example.after;

import com.example.after.adapter.PixPaymentAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class PixPaymentAdapterTest {
    private PixPaymentAdapter pixPaymentAdapter;

    @BeforeEach
    void setUp() {
        pixPaymentAdapter = new PixPaymentAdapter();
    }

    @Test
    public void processPaymentSuccessfully() {
        assertDoesNotThrow(() ->
                pixPaymentAdapter.processPixPayment("token123", BigDecimal.valueOf(100)));
    }

    @Test
    public void getPaymentStatusSuccessfully() {
        assertDoesNotThrow(() ->
                pixPaymentAdapter.getPixPaymentStatus("token123"));
    }

    @Test
    public void refundCardPaymentSuccessfully() {
        assertDoesNotThrow(() ->
                pixPaymentAdapter.refundPixPayment("token123"));
    }
}