package com.example.before;

public class PaymentProcessingServiceBefore {
    private final MySqlPaymentRepositoryBefore repository;
    private final StripePaymentGatewayBefore gateway;

    public PaymentProcessingServiceBefore() {
        this.repository = new MySqlPaymentRepositoryBefore();
        this.gateway    = new StripePaymentGatewayBefore();
    }

    public void processPayment(String orderId, double amount) {
        Payment payment = new Payment(orderId, amount, "PROCESSING");
        gateway.charge(amount);
        payment.setStatus("COMPLETED");
        repository.save(payment);
    }
}
