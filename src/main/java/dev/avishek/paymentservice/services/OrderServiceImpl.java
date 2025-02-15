package dev.avishek.paymentservice.services;

import dev.avishek.paymentservice.dtos.OrderDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderServiceImpl implements OrderService {
    private RestTemplate restTemplate;
    public OrderServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public OrderDto getOrderDetails(Long orderId) {
        ResponseEntity<OrderDto> responseEntity = restTemplate.getForEntity(
                "http://localhost:8081/orders/" + orderId,
                OrderDto.class
        );
        return responseEntity.getBody();
    }
}
