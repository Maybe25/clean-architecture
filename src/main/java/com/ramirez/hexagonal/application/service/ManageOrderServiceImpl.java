package com.ramirez.hexagonal.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramirez.hexagonal.application.usecase.ManageOrderService;
import com.ramirez.hexagonal.domain.dto.Response;
import com.ramirez.hexagonal.domain.model.Order;
import com.ramirez.hexagonal.domain.service.OrderService;
import com.ramirez.hexagonal.domain.utils.ResponseGenerator;

@Service
public class ManageOrderServiceImpl implements ManageOrderService {

    
    private final OrderService orderService;

    public ManageOrderServiceImpl(OrderService orderService) {
        this.orderService = orderService;
    }
    

    @Override
    public Response<Order> findOrder(String orderId) {
        Order responseOrder = orderService.findById(orderId).getData();
        if(responseOrder == null) {
            return ResponseGenerator.callResponse("Order not found", null);
        }
        //Aqui va logica adicional que se desea agregar al encontrar una orden
        return ResponseGenerator.callResponse("orderId", responseOrder);
    }

    @Override
    public Response<String> saveOrder(Order order) {
        String savingMessage = "";
        try{
            savingMessage = orderService.save(order).getData();
        }catch(Exception e) {
            e.printStackTrace();
            return ResponseGenerator.callResponse("Error saving order", null);
        }
        return ResponseGenerator.callResponse("operacion guardada con exito", savingMessage);
    }
    
}
