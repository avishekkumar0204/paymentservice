package dev.avishek.paymentservice.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeneratePaymentLinkRequestDto {
    private Long orderId;
}
