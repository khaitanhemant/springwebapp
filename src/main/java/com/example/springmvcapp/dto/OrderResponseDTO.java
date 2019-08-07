package com.example.springmvcapp.dto;

import java.math.BigDecimal;
import java.util.List;

public class OrderResponseDTO {
    private long ordId;
    private BigDecimal amount;
    private List<ItemResponseDTO> orderItems;
    private String orderDate;

    public long getOrdId() {
        return ordId;
    }

    public void setOrdId(long ordId) {
        this.ordId = ordId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public List<ItemResponseDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<ItemResponseDTO> orderItems) {
        this.orderItems = orderItems;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
}
