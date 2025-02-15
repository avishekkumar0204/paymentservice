package dev.avishek.paymentservice.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class RazarpayPaymentGateway implements PaymentService {
    public String generatePaymentLink(Long orderId) {
        return "Payment link generated successfully";
    }
}
