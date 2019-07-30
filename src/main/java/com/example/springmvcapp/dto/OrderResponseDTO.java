package com.example.springmvcapp.dto;

public class OrderResponseDTO {
    private OrderDTO order;
    private String message;

    public OrderDTO getOrder() {
        return order;
    }

    public void setOrder(OrderDTO order) {
        this.order = order;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
