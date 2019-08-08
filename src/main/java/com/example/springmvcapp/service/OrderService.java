package com.example.springmvcapp.service;

import com.example.springmvcapp.dto.ItemResponseDTO;
import com.example.springmvcapp.dto.OrderResponseDTO;
import com.example.springmvcapp.model.OrderEntity;
import com.example.springmvcapp.model.OrderItem;
import com.example.springmvcapp.model.Product;
import com.example.springmvcapp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemService orderItemService;
    @Autowired
    private ProductService productService;


    private void getTotalAmount(OrderEntity or, Map<Long, Integer> map) {
        Set<Long> i = map.keySet();
        List<Long> ids = new ArrayList<>(i);
        List<Product> products = productService.getAllProductsById(ids);
        for (Product product : products) {
            if (product != null) {
                or.setAmount(or.getAmount().add(product.getPrice().multiply(BigDecimal.valueOf(map.get(product.getProId())))));
            }
        }

    }

    private void addToMap(Map<Long, List<OrderItem>> map, Long ordId, OrderItem orderItem) {
        if (!map.containsKey(ordId)) {
            List<OrderItem> items = new ArrayList<>();
            items.add(orderItem);
            map.put(ordId, items);
        } else {
            List<OrderItem> orderItems = map.get(ordId);
            orderItems.add(orderItem);
        }
    }

    private void addToMap(Map<Long, Integer> map, List<OrderItem> orderItems) {
        for (OrderItem orderItem : orderItems) {
            if (orderItem.getQty() > 0) {
                if (!map.containsKey(orderItem.getProId())) {
                    map.put(orderItem.getProId(), orderItem.getQty());
                } else {
                    map.replace(orderItem.getProId(), map.get(orderItem.getProId()) + orderItem.getQty());
                }
            }
        }
    }

    private List<ItemResponseDTO> createItemResponseList(List<OrderItem> orderItems) {
        final List<ItemResponseDTO> items = new ArrayList<>();
        Set<Long> i = new HashSet<>();
        for (OrderItem orderItem : orderItems) {
            i.add(orderItem.getProId());
        }
        List<Long> ids = new ArrayList<>(i);
        final List<Product> products = productService.getAllProductsById(ids);
        final Map<Long, Integer> map = new HashMap<>();
        addToMap(map, orderItems);
        for (Product product : products) {
            final ItemResponseDTO item = new ItemResponseDTO();
            item.setProId(product.getProId());
            item.setQty(map.get(product.getProId()));
            item.setName(product.getName());
            item.setPrice(product.getPrice());
            items.add(item);
        }
        return items;
    }

    private List<OrderResponseDTO> getOrderResponseList(List<OrderEntity> orders, List<OrderItem> orderItems) {
        if (orders.isEmpty()) {
            return Collections.emptyList();
        }
        final List<OrderResponseDTO> resObjs = new ArrayList<>();
        final Map<Long, List<OrderItem>> orderIdMap = new HashMap<>();
        for (OrderItem orderItem : orderItems) {
            addToMap(orderIdMap, orderItem.getOrdId(), orderItem);
        }
        for (OrderEntity order : orders) {
            final OrderResponseDTO resObj = new OrderResponseDTO();
            resObj.setOrdId(order.getOrdId());
            resObj.setAmount(order.getAmount());
            final List<ItemResponseDTO> items = createItemResponseList(orderIdMap.get(order.getOrdId()));
            resObj.setOrderItems(items);
            resObj.setOrderDate(order.getOrderDate().toString());
            resObjs.add(resObj);
        }
        return resObjs;
    }

    private boolean validateOrder(OrderResponseDTO order) {
        if (order.getOrderItems().isEmpty()) {
            return false;
        }
        for (ItemResponseDTO orderItem : order.getOrderItems()) {
            if (orderItem.getQty() != 0) {
                return true;
            }
        }
        return false;
    }

    public List<OrderResponseDTO> getAllOrders(Integer pageNo,Integer pageSize) {

        Page<OrderEntity> pagedResult=orderRepository.findAll(PageRequest.of(pageNo,pageSize));
        final List<OrderEntity> orders = pagedResult.getContent();
        List<Long> ids=new ArrayList<>();
        for(OrderEntity order:orders)
        {
            ids.add(order.getOrdId());
        }
        final List<OrderItem> orderItems = orderItemService.getAllOrderItemsByOrdId(ids);
        List<OrderResponseDTO> response = getOrderResponseList(orders, orderItems);
        return response;
    }

    public List<OrderResponseDTO> getOrdersByIds(List<Long> ids) {
        final List<OrderEntity> orders = orderRepository.findAllById(ids);
        final List<OrderItem> orderItems = orderItemService.getAllOrderItemsByOrdId(ids);
        return getOrderResponseList(orders, orderItems);
    }

    public OrderEntity createOrder(OrderResponseDTO order) {
        final List<ItemResponseDTO> itemResponseDTOS = order.getOrderItems();
        final OrderEntity orderEntity = new OrderEntity();
        if (!validateOrder(order)) {
            return null;
        }
        final List<OrderItem> orderItems = new ArrayList<>();
        orderEntity.setAmount(BigDecimal.valueOf(0));
        String d = order.getOrderDate();
        LocalDate date = LocalDate.parse(d);
        orderEntity.setOrderDate(date);
        for (ItemResponseDTO itemResponseDTO : itemResponseDTOS) {
            OrderItem newOrderItem = new OrderItem();
            newOrderItem.setProId(itemResponseDTO.getProId());
            newOrderItem.setQty(itemResponseDTO.getQty());
            orderItems.add(newOrderItem);
        }
        final Map<Long, Integer> map = new HashMap<>();
        addToMap(map, orderItems);
        getTotalAmount(orderEntity, map);
        orderRepository.save(orderEntity);
        orderItemService.createOrderItemEntries(orderEntity, map);
        return orderEntity;
    }

    public List<OrderResponseDTO> getHistory(String from, String to,Integer pageNo,Integer pageSize) {
        LocalDate fromDate = LocalDate.parse(from);
        LocalDate toDate = LocalDate.parse(to);
        LocalDate toDatePlusOne = toDate.plusDays(1);
        List<OrderEntity> orders;
        if (fromDate.isAfter(toDatePlusOne)) {
            return null;
        } else {
            Page<OrderEntity> pagedResult=orderRepository.getAllByOrderDateBetween(fromDate,toDatePlusOne,PageRequest.of(pageNo,pageSize));
            orders = pagedResult.getContent();
            List<Long> ids = new ArrayList<>();
            for (OrderEntity order : orders) {
                ids.add(order.getOrdId());
            }
            return getOrdersByIds(ids);
        }
    }
}