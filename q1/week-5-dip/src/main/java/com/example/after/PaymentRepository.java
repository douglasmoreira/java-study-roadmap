package com.example.after;

public interface PaymentRepository {
    void save(Payment payment);
    Payment findById(String id);
}
