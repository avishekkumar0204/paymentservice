package dev.avishek.paymentservice.controllers;

import com.razorpay.RazorpayException;
import dev.avishek.paymentservice.dtos.GeneratePaymentLinkRequestDto;
import dev.avishek.paymentservice.services.PaymentService;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private PaymentService paymentService;
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    @PostMapping()
    public String generatePaymentLink(@RequestBody GeneratePaymentLinkRequestDto generatePaymentLinkRequestDto) throws RazorpayException {
        return paymentService.generatePaymentLink(generatePaymentLinkRequestDto.getOrderId());
    }
}
