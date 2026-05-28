package com.example.after;

public class StripePaymentGateway implements PaymentGateway {
    public void charge(double amount) {
        System.out.println("Charging " + amount + " via Stripe");
    }
}
