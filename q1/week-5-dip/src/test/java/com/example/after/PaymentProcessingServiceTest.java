package com.example.after;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PaymentProcessingServiceTest {
    private PaymentProcessingService service;
    @Mock
    private PaymentGateway gateway;
    @Mock
    private PaymentRepository paymentRepository;

    @BeforeEach
    void setUp() {
        service = new PaymentProcessingService(paymentRepository, gateway);
    }

    @Test
    void shouldChargeGatewayAndSavePaymentWhenProcessing() {
        ArgumentCaptor<Payment> captor = ArgumentCaptor.forClass(Payment.class);

        service.processPayment("orderId123", 10000);

        verify(gateway).charge(10000);

        verify(paymentRepository).save(captor.capture());
        assertEquals("COMPLETED", captor.getValue().getStatus());
    }
}