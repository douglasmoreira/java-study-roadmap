package com.example.after.processor;

import com.example.after.PaymentStatus;

import java.math.BigDecimal;

public interface CardProcessor{
    void processCardPayment(String cardToken, BigDecimal amount);
    void refundCardPayment(String transactionId, BigDecimal amount);
    PaymentStatus getCardPaymentStatus(String transactionId);
}
