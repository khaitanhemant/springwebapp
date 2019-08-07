package com.example.springmvcapp.dto;

import com.example.springmvcapp.model.OrderItem;

import java.util.List;

public class GetOrderItemDTO {
    private List<OrderItem> orderItems;
    private String message;

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
