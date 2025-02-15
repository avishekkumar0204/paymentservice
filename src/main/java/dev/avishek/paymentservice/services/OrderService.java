package dev.avishek.paymentservice.services;

import dev.avishek.paymentservice.dtos.ResponseOrderDto;

public interface OrderService {
    public ResponseOrderDto getOrderDetails(Long orderId);
}
