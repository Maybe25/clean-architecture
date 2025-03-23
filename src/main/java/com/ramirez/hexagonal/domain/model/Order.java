package com.ramirez.hexagonal.domain.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import lombok.Builder;

@Builder
public class Order {
    private String orderId;
    private String customerName;
    private OrderDetail detail;
    private double totalAmount;
    private String dateRegister;

    public Order() {
    }

    public Order(String orderId, String customerName, OrderDetail detail, double totalAmount, String dateRegister) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.detail = detail;
        this.totalAmount = totalAmount;
        this.dateRegister = dateRegister;
    }

    public Order(String customerName, OrderDetail detail, double totalAmount) {
        this.orderId = UUID.randomUUID().toString();
        this.customerName = customerName;
        this.detail = detail;
        this.totalAmount = totalAmount;
        addDateRegister();
        applyTimeDiscount();
        calculateTotalAmount();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public OrderDetail getDetail() {
        return detail;
    }

    public void setDetail(OrderDetail detail) {
        this.detail = detail;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(String dateRegister) {
        this.dateRegister = dateRegister;
    }

    private void addDateRegister() {
        LocalDateTime now = LocalDateTime.now(java.time.ZoneId.of("America/Lima"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.dateRegister = now.format(formatter);
    }

    // business logic
    public void calculateTotalAmount() {
        double totalAmountCalculate = this.totalAmount;
        if (totalAmountCalculate > 10000 && totalAmountCalculate <= 50000) {
            this.totalAmount = totalAmountCalculate * 0.9;
        } else if (totalAmountCalculate > 50000) {
            this.totalAmount = totalAmountCalculate * 0.8;
        }
    }

    public void applyTimeDiscount() {
        if (dateRegister != null) {

            LocalDateTime orderTime = LocalDateTime.parse(dateRegister,
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            if (orderTime.getHour() < 18) {
                this.totalAmount = this.totalAmount * 0.95;
            }

        }
    }

}