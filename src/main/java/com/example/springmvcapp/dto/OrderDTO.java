package com.example.springmvcapp.dto;

import java.util.List;

public class OrderDTO {
    String ordid;
    double amount;
    List<ItemObject> orderitems;

    public String getOrdid() {
        return ordid;
    }

    public void setOrdid(String ordid) {
        this.ordid = ordid;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public List<ItemObject> getOrderitems() {
        return orderitems;
    }

    public void setOrderitems(List<ItemObject> orderitems) {
        this.orderitems = orderitems;
    }
}
