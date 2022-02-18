package com.example.restapi.service;

import com.example.restapi.model.Order;
import com.example.restapi.model.request.OrderCreationRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrderService {
    List<Order> getAll();
    void createOrder(OrderCreationRequest orderCreationRequest);
}
