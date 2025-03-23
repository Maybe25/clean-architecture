package com.ramirez.hexagonal.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramirez.hexagonal.domain.dto.Response;
import com.ramirez.hexagonal.domain.model.Order;
import com.ramirez.hexagonal.domain.repository.OrderRepository;
import com.ramirez.hexagonal.domain.utils.ResponseGenerator;

@Service
public class OrderService {

    @Autowired
    private  OrderRepository repository;
    
    //Logic business for saving a order in the repository
    
    public Response<String> save(Order order) {
        Order orderSaved = new Order(order.getCustomerName(), order.getDetail(), order.getTotalAmount());
        repository.save(orderSaved);
        return ResponseGenerator.callResponse("Order saved", null);
    }

    public Response<Order> findById(String orderId) {
        Order order = repository.findById(orderId, Optional.empty());
        return ResponseGenerator.callResponse("Order found", order);
    }
    
}
