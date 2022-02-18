package com.example.restapi.service;

import com.example.restapi.model.Order;
import com.example.restapi.model.request.OrderCreationRequest;
import com.example.restapi.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAll() {
        return orderRepository.findAll();
    }
    public void createOrder(OrderCreationRequest orderCreationRequest) {
        orderRepository.save(new Order(
                orderCreationRequest.getItem(),
                orderCreationRequest.getQuantity()));
    }
}
