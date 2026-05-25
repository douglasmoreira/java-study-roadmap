package com.example.after;

import com.example.after.adapter.BoletoPaymentAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.OutputStream;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class BoletoPaymentAdapterTest {
    private BoletoPaymentAdapter boletoPaymentAdapter;

    @BeforeEach
    void setUp() {
        boletoPaymentAdapter = new BoletoPaymentAdapter();
    }

    @Test
    public void processPaymentSuccessfully() {
        assertDoesNotThrow(() ->
                boletoPaymentAdapter.processBoletoPayment("token123", BigDecimal.valueOf(100)));
    }

    @Test
    public void getPaymentStatusSuccessfully() {
        assertDoesNotThrow(() ->
                boletoPaymentAdapter.getBoletoPaymentStatus("token123"));
    }

    @Test
    public void refundCardPaymentSuccessfully() {
        assertDoesNotThrow(() ->
                boletoPaymentAdapter.generateBoletoPdf("token123", OutputStream.nullOutputStream()));
    }
}