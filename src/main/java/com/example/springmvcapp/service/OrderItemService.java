package com.example.springmvcapp.service;

import com.example.springmvcapp.model.OrderItem;
import com.example.springmvcapp.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    public List<OrderItem> getAllOrderItems()
    {
        return orderItemRepository.findAll();
    }

    public Optional<OrderItem> getOrderItem(Integer id)
    {
        return orderItemRepository.findById(id);
    }

    public List<OrderItem> getAllOrderItemsByOrdId(Integer id){return orderItemRepository.findByOrdId(id);}

    public void saveAllOrderItems(List<OrderItem> ois){orderItemRepository.saveAll(ois);}

}
