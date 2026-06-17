package com.example.before;

import java.util.List;
import java.util.UUID;

public class Order {

    private String id;
    private double total;
    private String trackingCode;
    private List<Customer> customers;

    public Order(double total, String trackingCode, List<Customer> customers) {
        this.id = UUID.randomUUID().toString();
        this.total = total;
        this.trackingCode = trackingCode;
        this.customers = customers;
    }

    public String getId() {
        return id;
    }

    public double getTotal() {
        return total;
    }

    public String getTrackingCode() {
        return trackingCode;
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}
