package com.example.springmvcapp.model;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public int ordid;
    public int proid;
    public int qty;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrdid() {
        return ordid;
    }

    public void setOrdid(int ordid) { this.ordid = ordid; }

    public int getProid() {
        return proid;
    }

    public void setProid(int proid) {
        this.proid = proid;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
