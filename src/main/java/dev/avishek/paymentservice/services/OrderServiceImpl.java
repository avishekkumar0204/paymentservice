package dev.avishek.paymentservice.services;

import dev.avishek.paymentservice.dtos.ResponseOrderDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderServiceImpl implements OrderService {
    private RestTemplate restTemplate;
    public OrderServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public ResponseOrderDto getOrderDetails(Long orderId) {
        ResponseEntity<ResponseOrderDto> responseEntity = restTemplate.getForEntity(
                "http://localhost:8081/orders/" + orderId,
                ResponseOrderDto.class
        );
        return responseEntity.getBody();
    }
}
