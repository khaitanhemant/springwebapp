package com.example.springmvcapp.model;



import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Product {

    @Id
    // TODO generation type
    private long proId;
    private String name;
    // TODO use bigdecimal
    private BigDecimal price;

    public long getProId() {
        return proId;
    }

    public void setProId(long proid) {
        this.proId = proid;
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
