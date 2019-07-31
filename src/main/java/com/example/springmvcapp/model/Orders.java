package com.example.springmvcapp.model;

import javax.persistence.*;

// Model name should be singular - Done (Cant for orders because keyword in MySQL)
// Amount should be bigdecimal
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ordId;
    private double amount;

    public int getOrdId() {
        return ordId;
    }

    public void setOrdId(int ordId) {
        this.ordId = ordId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
