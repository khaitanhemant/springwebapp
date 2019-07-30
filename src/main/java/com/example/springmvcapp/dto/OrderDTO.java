package com.example.springmvcapp.dto;

import java.util.List;

public class OrderDTO {
    int ordid;
    double amount;
    List<ItemObject> orderitems;

    public int getOrdid() {
        return ordid;
    }

    public void setOrdid(int ordid) {
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
