package com.example.springmvcapp.service;

import com.example.springmvcapp.dto.ItemObject;
import com.example.springmvcapp.dto.OrderCreateDTO;
import com.example.springmvcapp.dto.OrderDTO;
import com.example.springmvcapp.model.OrderItems;
import com.example.springmvcapp.model.Orders;
import com.example.springmvcapp.model.Products;
import com.example.springmvcapp.repository.OrderItemRepository;
import com.example.springmvcapp.repository.OrderRepository;
import com.example.springmvcapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private ProductRepository productRepository;

    public OrderDTO getOrder(int id)
    {
        Optional<Orders> order = orderRepository.findById(id);
        OrderDTO obj=new OrderDTO();
        obj.setOrdid(order.get().ordid);
        obj.setAmount(order.get().amount);
        List<OrderItems> oi = orderItemRepository.findByOrdid(id);
        List<ItemObject> items=new ArrayList<>();
        for(int i=0;i<oi.size();i++)
        {
            ItemObject item=new ItemObject();
            item.setProid(oi.get(i).proid);
            item.setQty(oi.get(i).qty);
            Optional<Products> product= productRepository.findById(oi.get(i).proid);
            item.setName(product.get().getName());
            item.setPrice(product.get().getPrice());
            items.add(item);
        }
        obj.setOrderitems(items);
        return obj;
    }

    public List<OrderDTO> getallOrders()
    {
        List<Orders> orders = orderRepository.findAll();
        List<OrderDTO> objs=new ArrayList<>();
        for(int i=0;i<orders.size();i++)
        {
            OrderDTO obj=new OrderDTO();
            obj.setOrdid(orders.get(i).ordid);
            obj.setAmount(orders.get(i).amount);
            List<OrderItems> oi = orderItemRepository.findByOrdid(orders.get(i).ordid);
            List<ItemObject> items=new ArrayList<>();
            for(int j=0;j<oi.size();j++)
            {
                ItemObject item=new ItemObject();
                item.setProid(oi.get(j).proid);
                item.setQty(oi.get(j).qty);
                Optional<Products> product= productRepository.findById(oi.get(j).proid);
                item.setName(product.get().getName());
                item.setPrice(product.get().getPrice());
                items.add(item);
            }
            obj.setOrderitems(items);
            objs.add(obj);
        }
        return objs;

    }

    public String createOrder(OrderCreateDTO order)
    {
        Orders or=new Orders();
        or.setAmount(0);
        for(int i=0;i<order.orderitems.size();i++)
        {
            or.amount+=order.orderitems.get(i).getQty()*order.orderitems.get(i).getPrice();
        }
        or.setAmount(or.amount);
        Orders o=orderRepository.save(or);

        List<OrderItems> ois=new ArrayList<OrderItems>();
        for(int i=0;i<order.orderitems.size();i++)
        {
            OrderItems item=new OrderItems();
            item.setOrdid(or.getOrdid());
            item.setProid(order.orderitems.get(i).getProid());
            item.setQty(order.orderitems.get(i).getQty());
            ois.add(item);
        }
        orderItemRepository.saveAll(ois);
        return "Your order "+o.getOrdid()+" has been created!";
    }


}
