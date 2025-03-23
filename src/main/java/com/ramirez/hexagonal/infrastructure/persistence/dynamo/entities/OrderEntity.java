package com.ramirez.hexagonal.infrastructure.persistence.dynamo.entities;


import com.ramirez.hexagonal.domain.model.OrderDetail;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@DynamoDbBean
public class OrderEntity {

    private String orderId;
    private String customerName;
    private double totalAmount;
    private String dateRegister;
    private OrderDetailEntity detail;

    /**
     * Default constructor required by DynamoDB SDK for object mapping
     */
    public OrderEntity() {
    }

    @DynamoDbPartitionKey
    @DynamoDbAttribute("idOrder")
    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    @DynamoDbAttribute("customerName")
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    @DynamoDbAttribute("detail")
    public OrderDetailEntity getDetail() {
        return detail;
    }
    public void setDetail(OrderDetailEntity detail) {
        this.detail = detail;
    }

    @DynamoDbAttribute("totalAmount")
    public double getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
    @DynamoDbAttribute("dateRegister")
    public String getDateRegister() {
        return dateRegister;
    }
    public void setDateRegister(String dateRegister) {
        this.dateRegister = dateRegister;
    }

    // Helper methods to convert between domain and entity
    public void setDetailFromDomain(OrderDetail orderDetail) {
        this.detail = new OrderDetailEntity(orderDetail);
    }
    
    public OrderDetail getDetailAsDomain() {
        return detail != null ? detail.toDomain() : null;
    }
    
    
}
