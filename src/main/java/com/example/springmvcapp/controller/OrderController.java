package com.example.springmvcapp.controller;

import com.example.springmvcapp.dto.*;
import com.example.springmvcapp.model.OrderItems;
import com.example.springmvcapp.model.Products;
import com.example.springmvcapp.service.OrderItemService;
import com.example.springmvcapp.service.OrderService;
import com.example.springmvcapp.model.Orders;
import com.example.springmvcapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/")
    public String home()
    {
        return "Welcome to my first spring web app";
    }

    @RequestMapping("/order/{id}")
    public OrderResponseDTO returnOrder(@PathVariable int id) { return orderService.getOrder(id); }

    @RequestMapping("/orders")
    public List<OrderDTO> returnAllOrders(){ return orderService.getAllOrders();}

    @RequestMapping(value = "/order/create", method = RequestMethod.POST)
    public String createOrder(@RequestBody OrderCreateDTO order){return orderService.createOrder(order);}

}
