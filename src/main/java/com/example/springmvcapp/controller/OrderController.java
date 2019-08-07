package com.example.springmvcapp.controller;

import com.example.springmvcapp.dto.GetOrderDTO;
import com.example.springmvcapp.dto.OrderResponseDTO;
import com.example.springmvcapp.model.OrderEntity;
import com.example.springmvcapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("")
    public GetOrderDTO returnAllOrders() {
        GetOrderDTO response = new GetOrderDTO();
        List<OrderResponseDTO> orders = orderService.getAllOrders();
        response.setOrders(orders);
        if (orders.isEmpty()) {
            response.setMessage("No orders exist");
        } else {
            response.setMessage("Returned all orders");
        }
        return response;
    }

    @RequestMapping("/{ids}")
    public GetOrderDTO returnOrder(@PathVariable List<Long> ids) {
        GetOrderDTO response = new GetOrderDTO();
        response.setOrders(orderService.getOrdersByIds(ids));
        List<Long> dupIds = new ArrayList<>(ids);
        if (response.getOrders().isEmpty()) {
            response.setMessage("No orders were found!");
        } else if (response.getOrders().size() < dupIds.size()) {
            for (OrderResponseDTO order : response.getOrders()) {
                dupIds.remove(order.getOrdId());
            }
            response.setMessage("These orders were not found :" + dupIds.toString());
        } else {
            response.setMessage("All orders were found");
        }
        return response;
    }

    @RequestMapping(value = "/history")
    public GetOrderDTO orderHistory(@RequestParam String from, @RequestParam String to) {
        GetOrderDTO response = new GetOrderDTO();
        List<OrderResponseDTO> orders = orderService.getHistory(from, to);
        response.setOrders(orders);
        if (response.getOrders() == null) {
            response.setMessage("Invalid range");
        } else if (response.getOrders().isEmpty()) {
            response.setMessage("No orders found in the specified range");
        } else {
            response.setMessage("Viewing orders within the specified range");
        }
        return response;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createOrder(@RequestBody OrderResponseDTO order) {
        final OrderEntity order1 = orderService.createOrder(order);
        if (order1 != null) {
            return "Your order with Order ID :" + order1.getOrdId() + " has been created";
        } else {
            return "Error : Order can't be created.";
        }
    }
}

