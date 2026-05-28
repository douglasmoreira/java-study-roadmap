package com.example.before;

public class StripePaymentGatewayBefore {
    public void charge(double amount) {
        System.out.println("Charging " + amount + " via Stripe");
    }
}
