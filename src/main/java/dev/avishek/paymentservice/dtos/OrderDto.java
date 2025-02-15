package dev.avishek.paymentservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto {
    private ProductDto productDetails;
    private UserDto userDetails;
    private String orderStatus;
}
