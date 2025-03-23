package com.ramirez.hexagonal.infrastructure.persistence.dynamo.mapper;

import com.ramirez.hexagonal.domain.model.Order;
import com.ramirez.hexagonal.infrastructure.persistence.dynamo.entities.OrderEntity;

public class OrderMapper {

    private OrderMapper() {
    }
    public static OrderEntity toEntity(Order order) {
        if (order == null) return null;
        
        OrderEntity entity = new OrderEntity();
        entity.setOrderId(order.getOrderId());
        entity.setCustomerName(order.getCustomerName());
        entity.setDetailFromDomain(order.getDetail());
        entity.setTotalAmount(order.getTotalAmount());
        entity.setDateRegister(order.getDateRegister());
        return entity;
    }
    
    public static Order toModel(OrderEntity entity) {
        if (entity == null) return null;
        
        return Order.builder()
            .orderId(entity.getOrderId())
            .customerName(entity.getCustomerName())
            .detail(entity.getDetailAsDomain())
            .totalAmount(entity.getTotalAmount())
            .dateRegister(entity.getDateRegister())
            .build();
    }
}