package com.example.springmvcapp.dto;

import java.util.List;

public class OrderDTO {
    private int ordId;
    private double amount;
    private List<ItemObject> orderItems;

    public int getOrdId() {
        return ordId;
    }

    public void setOrdId(int ordId) {
        this.ordId = ordId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public List<ItemObject> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<ItemObject> orderItems) {
        this.orderItems = orderItems;
    }
}
