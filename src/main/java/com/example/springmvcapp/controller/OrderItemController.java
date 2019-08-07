package com.example.springmvcapp.controller;

import com.example.springmvcapp.dto.GetOrderItemDTO;
import com.example.springmvcapp.model.OrderItem;
import com.example.springmvcapp.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orderitem")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @RequestMapping("")
    public GetOrderItemDTO returnAllOrderItems(){
        GetOrderItemDTO resObj=new GetOrderItemDTO();
        resObj.setOrderItems(orderItemService.getAllOrderItems());
        if(!resObj.getOrderItems().isEmpty())
        {
            resObj.setMessage("Returned all order item entries");
        }
        else
        {
            resObj.setMessage("No orders exist");
        }
        return resObj;
    }

    @RequestMapping("/{ids}")
    public GetOrderItemDTO returnOrderItem(@PathVariable List<Long> ids){
        GetOrderItemDTO response=new GetOrderItemDTO();
        response.setOrderItems(orderItemService.getOrderItemsByIds(ids));
        List<Long> dupIds = new ArrayList<>(ids);
        if (response.getOrderItems().isEmpty()) {
            response.setMessage("No order item entries were found!");
        } else if (response.getOrderItems().size() < dupIds.size()) {
            for (OrderItem orderItem : response.getOrderItems()) {
                dupIds.remove(orderItem.getId());
            }
            response.setMessage("These order items entries were not found :" + dupIds.toString());
        } else {
            response.setMessage("All order item entries were found");
        }
        return response;
    }

}
