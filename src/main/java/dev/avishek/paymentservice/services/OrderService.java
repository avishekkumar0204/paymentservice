package dev.avishek.paymentservice.services;

import dev.avishek.paymentservice.dtos.OrderDto;

public interface OrderService {
    public OrderDto getOrderDetails(Long orderId);
}
