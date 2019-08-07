package com.example.springmvcapp.service;

import com.example.springmvcapp.model.OrderEntity;
import com.example.springmvcapp.model.OrderItem;
import com.example.springmvcapp.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    public List<OrderItem> getOrderItemsByIds(List<Long> ids) {
        return orderItemRepository.findOrderItemsByIdIn(ids);
    }

    public List<OrderItem> getAllOrderItemsByOrdId(List<Long> ids) {
        return orderItemRepository.findOrderItemsByOrdIdIn(ids);
    }

    public void createOrderItemEntries(OrderEntity or, Map<Long, Integer> map) {
        final List<OrderItem> ois = new ArrayList<>();
        for (Map.Entry<Long, Integer> entry : map.entrySet()) {
            final OrderItem item = new OrderItem();
            item.setOrdId(or.getOrdId());
            item.setProId(entry.getKey());
            item.setQty(entry.getValue());
            ois.add(item);
        }
        orderItemRepository.saveAll(ois);
    }

}
