package com.ramirez.hexagonal.application.usecase;


import com.ramirez.hexagonal.domain.dto.Response;
import com.ramirez.hexagonal.domain.model.Order;

public interface ManageOrderService {

    public Response<String> saveOrder(Order order);
    public Response<Order> findOrder(String orderId);

}
