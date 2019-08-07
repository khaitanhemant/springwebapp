package com.example.springmvcapp.dto;

import java.util.List;

public class GetOrderDTO {
    private List<OrderResponseDTO> orders;
    private String message;

    public List<OrderResponseDTO> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderResponseDTO> orders) {
        this.orders = orders;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
