package com.example.before;

import java.util.List;

public class NotificationServiceBefore {

    private final EmailClient    emailClient;
    private final SmsClient      smsClient;
    private final PushClient     pushClient;
    private final AuditLogger    auditLogger;

    public NotificationServiceBefore(EmailClient emailClient,
                               SmsClient smsClient,
                               PushClient pushClient,
                               AuditLogger auditLogger) {
        this.emailClient = emailClient;
        this.smsClient   = smsClient;
        this.pushClient  = pushClient;
        this.auditLogger = auditLogger;
    }

    public void notifyOrderConfirmed(Order order) {
        List<Customer> eligible = order.getCustomers().stream()
                .filter(c -> c != null && c.isActive() && c.hasEmail()
                        && !c.isBlacklisted() && c.getPreferences() != null
                        && c.getPreferences().allowsEmail())
                .toList();

        for (Customer customer : eligible) {
            String msg = "[ORDER-" + order.getId().toUpperCase()
                    .substring(0, 8) + "] " + "Your order has been confirmed. Total: R$"
                    + String.format("%.2f", order.getTotal());
            emailClient.send(customer.getEmail(), "Order Confirmed", msg);
            auditLogger.log("EMAIL_SENT", customer.getId(), order.getId());
        }
    }

    public void notifyOrderShipped(Order order) {
        List<Customer> eligible = order.getCustomers().stream()
                .filter(c -> c != null && c.isActive() && c.hasEmail()
                        && !c.isBlacklisted() && c.getPreferences() != null
                        && c.getPreferences().allowsEmail())
                .toList();

        for (Customer customer : eligible) {
            String msg = "[ORDER-" + order.getId().toUpperCase()
                    .substring(0, 8) + "] " + "Your order has been shipped. Tracking: "
                    + order.getTrackingCode();
            emailClient.send(customer.getEmail(), "Order Shipped", msg);
            auditLogger.log("EMAIL_SENT", customer.getId(), order.getId());
        }
    }

    public void notifyOrderDelivered(Order order) {
        List<Customer> eligible = order.getCustomers().stream()
                .filter(c -> c != null && c.isActive() && c.hasEmail()
                        && !c.isBlacklisted() && c.getPreferences() != null
                        && c.getPreferences().allowsEmail())
                .toList();

        for (Customer customer : eligible) {
            String msg = "[ORDER-" + order.getId().toUpperCase()
                    .substring(0, 8) + "] " + "Your order has been delivered. Thank you!";
            emailClient.send(customer.getEmail(), "Order Delivered", msg);
            auditLogger.log("EMAIL_SENT", customer.getId(), order.getId());
        }
    }

    public void notifyByWhatsApp(Order order) {
        // TODO: integrate with WhatsApp Business API when approved
        // Estimated: Q3
        throw new UnsupportedOperationException("WhatsApp integration not yet available");
    }

    public void scheduleNotificationForLater(Order order, java.time.LocalDateTime deliveryTime) {
        // TODO: implement when we have a scheduling infrastructure
        throw new UnsupportedOperationException("Scheduled notifications not yet implemented");
    }

    public void notifyBySmsWithFallback(Order order) {
        // TODO: design fallback chain (SMS -> Push -> Email)
        throw new UnsupportedOperationException("SMS with fallback not yet implemented");
    }
}
