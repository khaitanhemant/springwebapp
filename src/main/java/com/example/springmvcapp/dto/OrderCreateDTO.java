package com.example.springmvcapp.dto;

import java.util.List;

public class OrderCreateDTO {
    private List<ItemObject> orderItems;

    public List<ItemObject> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<ItemObject> orderItems) {
        this.orderItems = orderItems;
    }
}
