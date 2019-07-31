package com.example.springmvcapp.dto;

import com.example.springmvcapp.model.Product;

public class ProductResponseDTO {
    private Product product;
    private String message;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
