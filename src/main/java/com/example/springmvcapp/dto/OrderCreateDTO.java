package com.example.springmvcapp.dto;

import java.util.List;

public class OrderCreateDTO {
    public List<ItemObject> orderitems;

    public List<ItemObject> getOrderitems() {
        return orderitems;
    }

    public void setOrderitems(List<ItemObject> orderitems) {
        this.orderitems = orderitems;
    }
}
