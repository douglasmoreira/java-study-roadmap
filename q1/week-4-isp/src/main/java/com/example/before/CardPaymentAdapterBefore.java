package com.example.before;

import java.io.OutputStream;
import java.math.BigDecimal;

public class CardPaymentAdapterBefore implements PaymentProcessorBefore {

    @Override
    public void processCardPayment(String cardToken, BigDecimal amount) {
        // Calls Stripe API
    }

    @Override
    public void processPixPayment(String pixKey, BigDecimal amount) {
        throw new UnsupportedOperationException("Not a PIX processor");
    }

    @Override
    public void processBoletoPayment(String cpf, BigDecimal amount) {
        throw new UnsupportedOperationException("Not a Boleto processor");
    }

    @Override
    public void refundCardPayment(String transactionId, BigDecimal amount) {
        // Calls Stripe refund API
    }

    @Override
    public void refundPixPayment(String transactionId) {
        throw new UnsupportedOperationException("Not a PIX processor");
    }

    @Override
    public PaymentStatus getCardPaymentStatus(String transactionId) {
        return PaymentStatus.APPROVED; // simplified
    }

    @Override
    public PaymentStatus getPixPaymentStatus(String transactionId) {
        throw new UnsupportedOperationException("Not a PIX processor");
    }

    @Override
    public PaymentStatus getBoletoPaymentStatus(String transactionId) {
        throw new UnsupportedOperationException("Not a Boleto processor");
    }

    @Override
    public void generateBoletoPdf(String transactionId, OutputStream out) {
        throw new UnsupportedOperationException("Not a Boleto processor");
    }
}
