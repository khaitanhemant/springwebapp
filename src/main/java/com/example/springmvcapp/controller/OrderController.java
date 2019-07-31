package com.example.springmvcapp.controller;

import com.example.springmvcapp.dto.OrderCreateDTO;
import com.example.springmvcapp.dto.OrderDTO;
import com.example.springmvcapp.dto.OrderResponseDTO;
import com.example.springmvcapp.model.Orders;
import com.example.springmvcapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    //TODO remove this - done


    // TODO make /order at controller level - done

    @RequestMapping("/{id}")
    public OrderResponseDTO returnOrder(@PathVariable int id) {
        OrderResponseDTO resObj=orderService.getOrder(id);
        if(resObj.getOrder()!=null)
            resObj.setMessage("Success! Order found.");
        else
            resObj.setMessage("Error: Order does not exist!");
        return resObj;
    }

    @RequestMapping("")
    public List<OrderDTO> returnAllOrders(){ return orderService.getAllOrders();}

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createOrder(@RequestBody OrderCreateDTO order){
        Orders or= orderService.createOrder(order);
        if(or!=null)
            return "Your order with Order ID :"+or.getOrdId()+" has been created";
        else
            return "Error : Order can't be created.";
    }

}
