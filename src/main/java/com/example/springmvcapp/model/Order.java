package com.example.springmvcapp.model;

import java.util.List;

public class Order {
    String orderid;
    double amount;
    List<OrderItem> orderitems;

    public String getOrderid() {
        return orderid;
    }

    public double getAmount() {
        return amount;
    }

    public List<OrderItem> getOrderitems() {
        return orderitems;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderid='" + orderid + '\'' +
                ", amount=" + amount +
                ", orderitems=" + orderitems +
                '}';
    }
}
