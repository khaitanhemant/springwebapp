package com.example.springmvcapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long ordId;
    private long proId;
    private int qty;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOrdId() {
        return ordId;
    }

    public void setOrdId(long ordId) {
        this.ordId = ordId;
    }

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
}
