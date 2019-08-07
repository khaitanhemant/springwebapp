package com.example.springmvcapp.dto;

import com.example.springmvcapp.model.Product;

import java.util.List;

public class GetProductDTO {
    private List<Product> products;
    private String message;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
