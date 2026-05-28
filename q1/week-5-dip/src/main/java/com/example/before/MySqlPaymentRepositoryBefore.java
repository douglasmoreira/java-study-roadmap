package com.example.before;

public class MySqlPaymentRepositoryBefore {
    public void save(Payment payment) {
        System.out.println("Saving payment to MySQL: " + payment.getId());
    }

    public Payment findById(String id) {
        System.out.println("Fetching payment from MySQL: " + id);
        return new Payment(id, 100.0, "PENDING");
    }
}
