package com.example.springmvcapp.controller;

import com.example.springmvcapp.model.OrderItems;
import com.example.springmvcapp.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @RequestMapping("/orderitem/{id}")
    public Optional<OrderItems> returnOrderItem(@PathVariable Integer id){ return orderItemService.getOrderItem(id); }

    @RequestMapping("/orderitems")
    public List<OrderItems> returnAllOrderItems(){ return orderItemService.getAllOrderItems();}

}
