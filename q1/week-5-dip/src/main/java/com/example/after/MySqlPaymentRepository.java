package com.example.after;

public class MySqlPaymentRepository implements PaymentRepository {
    public void save(Payment payment) {
        System.out.println("Saving payment to MySQL: " + payment.getId());
    }

    public Payment findById(String id) {
        System.out.println("Fetching payment from MySQL: " + id);
        return new Payment(id, 100.0, "PENDING");
    }
}
