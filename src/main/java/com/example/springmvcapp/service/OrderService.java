package com.example.springmvcapp.service;

import com.example.springmvcapp.dto.ItemObject;
import com.example.springmvcapp.dto.OrderCreateDTO;
import com.example.springmvcapp.dto.OrderDTO;
import com.example.springmvcapp.dto.OrderResponseDTO;
import com.example.springmvcapp.model.OrderItems;
import com.example.springmvcapp.model.Orders;
import com.example.springmvcapp.model.Products;
import com.example.springmvcapp.repository.OrderItemRepository;
import com.example.springmvcapp.repository.OrderRepository;
import com.example.springmvcapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    // TODO use service
    @Autowired
    private OrderItemRepository orderItemRepository;

    // TODO Use service
    @Autowired
    private ProductRepository productRepository;

    public List<ItemObject> orderItemsCommon(List<OrderItems> orderItems) {
        List<ItemObject> items = new ArrayList<>();
        for (OrderItems oi : orderItems) {
            ItemObject item = new ItemObject();
            item.setProId(oi.getProId());
            item.setQty(oi.getQty());
            Optional<Products> product = productRepository.findById(oi.getProId());
            if (product.isPresent()) {
                item.setName(product.get().getName());
                item.setPrice(product.get().getPrice());
                items.add(item);
            }
        }
        return items;
    }


    // TODO this method should return list of orders
    public OrderResponseDTO getOrder(int id) {
        OrderResponseDTO resObj = new OrderResponseDTO();
        Optional<Orders> order = orderRepository.findById(id);
        // TODO this check is wrong
        if (order.isPresent()) {
            OrderDTO obj = new OrderDTO();
            obj.setOrdId(order.get().getOrdId());
            obj.setAmount(order.get().getAmount());
            List<OrderItems> orderItems = orderItemRepository.findByOrdId(id);
            List<ItemObject> items = orderItemsCommon(orderItems);
            obj.setOrderItems(items);
            resObj.setOrder(obj);
            resObj.setMessage("Success! Order found.");
            return resObj;
        } else {
            resObj.setMessage("Error: Order does not exist!");
            return resObj;
        }
    }

    // TODO dont call db in a loop
    public List<OrderDTO> getAllOrders() {
        List<Orders> orders = orderRepository.findAll();
        List<OrderDTO> objs = new ArrayList<>();
        for (Orders order : orders) {
            OrderDTO obj = new OrderDTO();
            obj.setOrdId(order.getOrdId());
            obj.setAmount(order.getAmount());
            List<OrderItems> orderItems = orderItemRepository.findByOrdId(order.getOrdId());
            List<ItemObject> items = orderItemsCommon(orderItems);
            obj.setOrderItems(items);
            objs.add(obj);
        }
        return objs;

    }

    // TODO this method should not return string. Only ID.
    public String createOrder(OrderCreateDTO order) {

        Orders or = new Orders();
        or.setAmount(0);
        List<ItemObject> orderItems = order.getOrderItems();
        // TODO check if order is empty or null
        HashMap<Integer, Integer> map = new HashMap<>();
        for (ItemObject orderItem : orderItems) {
            if (orderItem.getQty() > 0) {
                if (!map.containsKey(orderItem.getProId())) {
                    map.put(orderItem.getProId(), orderItem.getQty());
                } else {
                    map.replace(orderItem.getProId(), map.get(orderItem.getProId()) + orderItem.getQty());
                }
            } else {
                return "Invalid quantity!";
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Optional<Products> product = productRepository.findById(entry.getKey());
            if (product.isPresent()) {
                or.setAmount(or.getAmount() + (entry.getValue() * product.get().getPrice()));
            }
        }
        orderRepository.save(or);

        // TODO make a separate method to do this
        List<OrderItems> ois = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            OrderItems item = new OrderItems();
            item.setOrdId(or.getOrdId());
            item.setProId(entry.getKey());
            item.setQty(entry.getValue());
            ois.add(item);
        }
        orderItemRepository.saveAll(ois);
        return "Your order " + or.getOrdId() + " has been created!";
    }
}