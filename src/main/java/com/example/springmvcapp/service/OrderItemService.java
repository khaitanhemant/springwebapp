package com.example.springmvcapp.service;

import com.example.springmvcapp.model.OrderItems;
import com.example.springmvcapp.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    public List<OrderItems> getAllOrderItems()
    {
        return orderItemRepository.findAll();
    }

    public Optional<OrderItems> getOrderItem(Integer id)
    {
        return orderItemRepository.findById(id);
    }

}
