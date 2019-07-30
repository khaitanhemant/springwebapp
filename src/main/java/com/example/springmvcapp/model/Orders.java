package com.example.springmvcapp.model;

import org.hibernate.annotations.GenericGenerator;
import sun.rmi.rmic.Generator;

import javax.persistence.*;


@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int ordid;
    public double amount;

    public int getOrdid() {
        return ordid;
    }

    public void setOrdid(int ordid) {
        this.ordid = ordid;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
