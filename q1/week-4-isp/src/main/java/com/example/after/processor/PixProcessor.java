package com.example.after.processor;

import com.example.after.PaymentStatus;

import java.math.BigDecimal;

public interface PixProcessor  {
    void processPixPayment(String pixKey, BigDecimal amount);
    PaymentStatus getPixPaymentStatus(String transactionId);
    void refundPixPayment(String transactionId);
}
