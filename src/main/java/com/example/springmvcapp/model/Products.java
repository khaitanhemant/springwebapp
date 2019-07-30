package com.example.springmvcapp.model;



import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Products {

    @Id
    int proid;
    String name;
    double price;

    public int getProid() {
        return proid;
    }

    public void setProid(int proid) {
        this.proid = proid;
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
