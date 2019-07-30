package com.example.springmvcapp.dto;

import com.example.springmvcapp.model.Products;

public class ProductResponseDTO {
    private Products product;
    private String message;

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
