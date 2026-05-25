package com.example.after.adapter;

import com.example.after.PaymentStatus;
import com.example.after.processor.BoletoProcessor;

import java.io.OutputStream;
import java.math.BigDecimal;

public class BoletoPaymentAdapter implements BoletoProcessor {

    @Override
    public void processBoletoPayment(String cpf, BigDecimal amount) {
        // Calls Stripe API
    }

    @Override
    public void generateBoletoPdf(String transactionId, OutputStream out) {
        // Calls Stripe refund API
    }

    @Override
    public PaymentStatus getBoletoPaymentStatus(String transactionId) {
        return PaymentStatus.APPROVED; // simplified
    }

}
