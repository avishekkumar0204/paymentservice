package dev.avishek.paymentservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseOrderDto {
    private Long productId;
    private Long userId;
    private String orderStatus;
    private Double orderAmount;
}
