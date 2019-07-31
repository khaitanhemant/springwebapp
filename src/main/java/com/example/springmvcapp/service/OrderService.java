package com.example.springmvcapp.service;

import com.example.springmvcapp.dto.*;
import com.example.springmvcapp.model.OrderItem;
import com.example.springmvcapp.model.Orders;
import com.example.springmvcapp.repository.OrderRepository;
import com.example.springmvcapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    // TODO use service - Done
    @Autowired
    private OrderItemService orderItemService;

    // TODO Use service - Done


    @Autowired
    private ProductService productService;

    public List<OrderItem> createOrderItemEntries(Orders or, Map<Integer,Integer> map)
    {
        List<OrderItem> ois=new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            OrderItem item = new OrderItem();
            item.setOrdId(or.getOrdId());
            item.setProId(entry.getKey());
            item.setQty(entry.getValue());
            ois.add(item);
        }
        return ois;
    }

    public List<ItemObject> orderItemsCommon(List<OrderItem> orderItems) {
        List<ItemObject> items = new ArrayList<>();
        for (OrderItem oi : orderItems) {
            ItemObject item = new ItemObject();
            item.setProId(oi.getProId());
            item.setQty(oi.getQty());
            ProductResponseDTO product = productService.getProduct(oi.getProId());
            if (product!=null) {
                item.setName(product.getProduct().getName());
                item.setPrice(product.getProduct().getPrice());
                items.add(item);
            }
        }
        return items;
    }


    // TODO this method should return list of orders -- Get a single order by ID.
    public OrderResponseDTO getOrder(int id) {
        OrderResponseDTO resObj = new OrderResponseDTO();
        Optional<Orders> order = orderRepository.findById(id);
        // TODO this check is wrong -- Guess its right. Only getting a single order.
        if (order.isPresent()) {
            OrderDTO obj = new OrderDTO();
            obj.setOrdId(order.get().getOrdId());
            obj.setAmount(order.get().getAmount());
            List<OrderItem> orderItems = orderItemService.getAllOrderItemsByOrdId(id);
            List<ItemObject> items = orderItemsCommon(orderItems);
            obj.setOrderItems(items);
            resObj.setOrder(obj);
            return resObj;
        } else {
            return resObj;
        }
    }

    // TODO dont call db in a loop --??
    public List<OrderDTO> getAllOrders() {
        List<Orders> orders = orderRepository.findAll();
        List<OrderDTO> objs = new ArrayList<>();
        for (Orders order : orders) {
            OrderDTO obj = new OrderDTO();
            obj.setOrdId(order.getOrdId());
            obj.setAmount(order.getAmount());
            List<OrderItem> orderItems = orderItemService.getAllOrderItemsByOrdId(order.getOrdId());
            List<ItemObject> items = orderItemsCommon(orderItems);
            obj.setOrderItems(items);
            objs.add(obj);
        }
        return objs;

    }

    // TODO this method should not return string. Only ID. - Done
    public Orders createOrder(OrderCreateDTO order) {

        Orders or = new Orders();
        or.setAmount(0);
        List<ItemObject> orderItems = order.getOrderItems();
        HashMap<Integer, Integer> map = new HashMap<>();
        // TODO check if order is empty or null - Done
        if(orderItems!=null) {
            for (ItemObject orderItem : orderItems) {
                if (orderItem.getQty() > 0) {
                    if (!map.containsKey(orderItem.getProId())) {
                        map.put(orderItem.getProId(), orderItem.getQty());
                    } else {
                        map.replace(orderItem.getProId(), map.get(orderItem.getProId()) + orderItem.getQty());
                    }
                } else {
                    return null;
                }
            }
        }
        else
        {
            return null;
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ProductResponseDTO product = productService.getProduct(entry.getKey());
            if (product!=null) {
                or.setAmount(or.getAmount() + (entry.getValue() * product.getProduct().getPrice()));
            }
        }
        orderRepository.save(or);

        // TODO make a separate method to do this - Done
        List<OrderItem> ois = createOrderItemEntries(or,map);

        orderItemService.saveAllOrderItems(ois);
        return or;
    }
}