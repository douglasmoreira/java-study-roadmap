package com.example.after;

import java.util.List;

public class NotificationService {

    private final EmailClient emailClient;
    private final AuditLogger auditLogger;

    public NotificationService(EmailClient emailClient,
                               AuditLogger auditLogger) {
        this.emailClient = emailClient;
        this.auditLogger = auditLogger;
    }

    public void notifyOrderConfirmed(Order order) {
        List<Customer> customers = order.getCustomers();
        String subject = "Order Confirmed";
        String msg = buildOrderRef(order) + "Your order has been confirmed. Total: R$"
                + String.format("%.2f", order.getTotal());

        sendOrderNotificationToEligibleCustomers(order, customers, subject, msg);
    }

    public void notifyOrderShipped(Order order) {
        List<Customer> customers = order.getCustomers();
        String subject = "Order Shipped";
        String msg = buildOrderRef(order) + "Your order has been shipped. Tracking: "
                + order.getTrackingCode();

        sendOrderNotificationToEligibleCustomers(order, customers, subject, msg);
    }

    public void notifyOrderDelivered(Order order) {
        List<Customer> customers = order.getCustomers();
        String subject = "Order Delivered";
        String msg = buildOrderRef(order) + "Your order has been delivered. Thank you!";

        sendOrderNotificationToEligibleCustomers(order, customers, subject, msg);
    }

    private void sendOrderNotificationToEligibleCustomers(Order order, List<Customer> customers, String subject, String msg) {
        for (Customer customer : customers) {
            if (customer.isEligible()) {
                emailClient.send(customer.getEmail(), subject, msg);
                auditLogger.log("EMAIL_SENT", customer.getId(), order.getId());
            }
        }
    }

    private static String buildOrderRef(Order order) {
        return "[ORDER-" + order.getId().toUpperCase()
                .substring(0, 8) + "] ";
    }
}
