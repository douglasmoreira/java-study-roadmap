package com.example.after;

public class PaymentProcessingService {
    private final PaymentRepository repository;
    private final PaymentGateway gateway;

    public PaymentProcessingService(PaymentRepository repository, PaymentGateway gateway) {
        this.repository = repository;
        this.gateway    = gateway;
    }

    public void processPayment(String orderId, double amount) {
        Payment payment = new Payment(orderId, amount, "PROCESSING");
        gateway.charge(amount);
        payment.setStatus("COMPLETED");
        repository.save(payment);
    }
}
