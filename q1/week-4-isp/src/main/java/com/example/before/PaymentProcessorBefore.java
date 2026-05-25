package com.example.before;

import java.io.OutputStream;
import java.math.BigDecimal;

public interface PaymentProcessorBefore {
    void processCardPayment(String cardToken, BigDecimal amount);
    void processPixPayment(String pixKey, BigDecimal amount);
    void processBoletoPayment(String cpf, BigDecimal amount);
    void refundCardPayment(String transactionId, BigDecimal amount);
    void refundPixPayment(String transactionId);
    PaymentStatus getCardPaymentStatus(String transactionId);
    PaymentStatus getPixPaymentStatus(String transactionId);
    PaymentStatus getBoletoPaymentStatus(String transactionId);
    void generateBoletoPdf(String transactionId, OutputStream out);
}
