package com.example.springmvcapp.controller;

import com.example.springmvcapp.dto.OrderCreateDTO;
import com.example.springmvcapp.dto.OrderDTO;
import com.example.springmvcapp.dto.OrderResponseDTO;
import com.example.springmvcapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    //TODO remove this
    @RequestMapping("/")
    public String home()
    {
        return "Welcome to my first spring web app";
    }

    // TODO make /order at controller level
    @RequestMapping("/order/{id}")
    public OrderResponseDTO returnOrder(@PathVariable int id) { return orderService.getOrder(id); }

    @RequestMapping("/orders")
    public List<OrderDTO> returnAllOrders(){ return orderService.getAllOrders();}

    @RequestMapping(value = "/order/create", method = RequestMethod.POST)
    public String createOrder(@RequestBody OrderCreateDTO order){return orderService.createOrder(order);}

}
