package com.ramirez.hexagonal.infrastructure.persistence.dynamo.entities;

import com.ramirez.hexagonal.domain.model.OrderDetail;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@DynamoDbBean
public class OrderDetailEntity {
    private String product;
    private int quantity;
    
    public OrderDetailEntity() {
    }

    public OrderDetailEntity(OrderDetail orderDetail) {
        if (orderDetail != null) {
            this.product = orderDetail.getProduct();
            this.quantity = orderDetail.getQuantity();
        }
    }

    public String getProduct() {
        return product;
    }
    public void setProduct(String product) {
        this.product = product;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OrderDetail toDomain() {
        return new OrderDetail(product, quantity);
    }
}
