package com.example.springmvcapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

// Model name should be singular - Done (Cant for orders because keyword in MySQL)
// Amount should be bigdecimal
@Entity
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ordId;
    private BigDecimal amount;
    private LocalDate orderDate;

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }



    public long getOrdId() {
        return ordId;
    }

    public void setOrdId(long ordId) {
        this.ordId = ordId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

}
