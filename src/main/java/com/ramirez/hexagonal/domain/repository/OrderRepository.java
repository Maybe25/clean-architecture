package com.ramirez.hexagonal.domain.repository;

import java.util.Optional;

import com.ramirez.hexagonal.domain.model.Order;

public interface OrderRepository {
    public void save(Order order);
    public Order findById(String orderId, Optional<String> sk);
    public void update(Order order);
}
