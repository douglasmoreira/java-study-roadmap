package com.example.after.processor;

import com.example.after.PaymentStatus;

import java.io.OutputStream;
import java.math.BigDecimal;

public interface BoletoProcessor {
    void processBoletoPayment(String cpf, BigDecimal amount);
    PaymentStatus getBoletoPaymentStatus(String transactionId);
    void generateBoletoPdf(String transactionId, OutputStream out);
}
