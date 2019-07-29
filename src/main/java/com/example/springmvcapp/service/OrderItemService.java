package com.example.springmvcapp.service;

import com.example.springmvcapp.model.OrderItems;
import com.example.springmvcapp.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    public List<OrderItems> getallOrderItems()
    {
        return orderItemRepository.findAll();
    }

    public Optional<OrderItems> getorderItem(Integer id)
    {
        return orderItemRepository.findById(id);
    }



}
