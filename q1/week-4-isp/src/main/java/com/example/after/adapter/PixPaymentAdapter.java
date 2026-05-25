package com.example.after.adapter;

import com.example.after.PaymentStatus;
import com.example.after.processor.PixProcessor;

import java.math.BigDecimal;

public class PixPaymentAdapter implements PixProcessor {

    @Override
    public void processPixPayment(String pixToken, BigDecimal amount) {
        // Calls Stripe API
    }

    @Override
    public void refundPixPayment(String transactionId) {
        // Calls Stripe refund API
    }

    @Override
    public PaymentStatus getPixPaymentStatus(String transactionId) {
        return PaymentStatus.APPROVED; // simplified
    }

}
