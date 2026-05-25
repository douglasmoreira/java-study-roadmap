package com.example.after.adapter;

import com.example.after.PaymentStatus;
import com.example.after.processor.CardProcessor;

import java.math.BigDecimal;

public class CardPaymentAdapter implements CardProcessor {

    @Override
    public void processCardPayment(String cardToken, BigDecimal amount) {
        // Calls Stripe API
    }

    @Override
    public void refundCardPayment(String transactionId, BigDecimal amount) {
        // Calls Stripe refund API
    }

    @Override
    public PaymentStatus getCardPaymentStatus(String transactionId) {
        return PaymentStatus.APPROVED; // simplified
    }

}
