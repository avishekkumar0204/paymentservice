package dev.avishek.paymentservice.services;

public interface PaymentService {
    public String generatePaymentLink(Long orderId);
}
