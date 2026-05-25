package com.example.before;

import org.junit.jupiter.api.Test;

import java.io.OutputStream;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CardPaymentAdapterTest {

    @Test
    public void processAnotherPaymentThrowException() {
        CardPaymentAdapterBefore cardPaymentAdapter = new CardPaymentAdapterBefore();

        assertThrows(
                UnsupportedOperationException.class, () ->
                cardPaymentAdapter.processPixPayment("transationId", BigDecimal.valueOf(15)));
        assertThrows(
                UnsupportedOperationException.class, () ->
                cardPaymentAdapter.processBoletoPayment("transationId", BigDecimal.valueOf(15)));
    }

    @Test
    public void refundAnotherPaymentThrowException() {
        CardPaymentAdapterBefore cardPaymentAdapter = new CardPaymentAdapterBefore();

        assertThrows(
                UnsupportedOperationException.class, () ->
                        cardPaymentAdapter.refundPixPayment("transationId"));
    }

    @Test
    public void getAnotherStatusThrowException() {
        CardPaymentAdapterBefore cardPaymentAdapter = new CardPaymentAdapterBefore();

        assertThrows(
                UnsupportedOperationException.class, () ->
                        cardPaymentAdapter.getPixPaymentStatus("transationId"));
        assertThrows(
                UnsupportedOperationException.class, () ->
                        cardPaymentAdapter.getBoletoPaymentStatus("transationId"));
    }

    @Test
    public void genarateBoletoPdfThrowException() {
        CardPaymentAdapterBefore cardPaymentAdapter = new CardPaymentAdapterBefore();

        assertThrows(UnsupportedOperationException.class, () ->
                cardPaymentAdapter.generateBoletoPdf(
                        "transationId", OutputStream.nullOutputStream()));
    }
}