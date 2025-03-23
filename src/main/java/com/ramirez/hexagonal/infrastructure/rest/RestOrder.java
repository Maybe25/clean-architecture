package com.ramirez.hexagonal.infrastructure.rest;

import org.springframework.web.bind.annotation.*;

import com.ramirez.hexagonal.application.usecase.ManageOrderService;
import com.ramirez.hexagonal.domain.model.Order;


@RestController
@RequestMapping("/orders")
public class RestOrder {

    private ManageOrderService manageOrderService;

    public RestOrder(ManageOrderService manageOrderService) {
        this.manageOrderService = manageOrderService;
    }

    @GetMapping("/{orderId}")
    public Object findOrder(@PathVariable String orderId) {
        return manageOrderService.findOrder(orderId);
    }

    @PostMapping
    public Object saveOrder(@RequestBody Order order) {
        return manageOrderService.saveOrder(order);
    }

    
}