package com.ramirez.hexagonal.domain.model;

public class OrderDetail {
    private String product;
    private int quantity;

    public OrderDetail() {
    }

    public OrderDetail(String product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    // Getters and setters

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
}