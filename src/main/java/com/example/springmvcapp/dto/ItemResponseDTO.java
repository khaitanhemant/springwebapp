package com.example.springmvcapp.dto;

import java.math.BigDecimal;

public class ItemResponseDTO {
    private long proId;
    private String name;
    private BigDecimal price;
    private int qty;

    public long getProId() {
        return proId;
    }

    public void setProId(long proId) {
        this.proId = proId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
