package com.example.springmvcapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Orders {
    @Id
    public String ordid;
    public double amount;

    public String getOrdid() {
        return ordid;
    }

    public void setOrdid(String ordid) {
        this.ordid = ordid;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
