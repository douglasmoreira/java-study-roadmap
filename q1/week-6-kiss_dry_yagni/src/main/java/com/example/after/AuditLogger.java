package com.example.after;

public class AuditLogger {

    public void log(String event, String customerId, String orderId) {
        System.out.println(
                "AUDIT | event=" + event +
                        " customer=" + customerId +
                        " order=" + orderId
        );
    }
}
