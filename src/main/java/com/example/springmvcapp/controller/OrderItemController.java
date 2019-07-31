package com.example.springmvcapp.controller;

import com.example.springmvcapp.model.OrderItem;
import com.example.springmvcapp.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orderitem")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @RequestMapping("/{id}")
    public Optional<OrderItem> returnOrderItem(@PathVariable Integer id){ return orderItemService.getOrderItem(id); }

    // TODO make consistent mapping - done
    @RequestMapping("")
    public List<OrderItem> returnAllOrderItems(){ return orderItemService.getAllOrderItems();}

}
