package com.example.springmvcapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;


@Entity
public class Order {
    @Id
    public String orderid;
    public double amount;
    public int itemqty;
}
