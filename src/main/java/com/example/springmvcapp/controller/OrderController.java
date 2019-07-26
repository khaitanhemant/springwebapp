package com.example.springmvcapp.controller;

import com.example.springmvcapp.model.Order;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @RequestMapping("/")
    Order entry()
    {
        Order o1=new Order();
        o1.orderid="CAP001";
        o1.amount=300.00;
        o1.itemqty=2;
        return o1;
    }
}
