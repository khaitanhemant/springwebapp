package com.example.springmvcapp.model;



import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Products {

    @Id
    private int proId;
    private String name;
    private double price;

    public int getProId() {
        return proId;
    }

    public void setProId(int proid) {
        this.proId = proid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
