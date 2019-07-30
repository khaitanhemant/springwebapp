package com.example.springmvcapp.controller;

import com.example.springmvcapp.dto.OrderCreateDTO;
import com.example.springmvcapp.dto.OrderDTO;
import com.example.springmvcapp.model.OrderItems;
import com.example.springmvcapp.model.Products;
import com.example.springmvcapp.service.OrderItemService;
import com.example.springmvcapp.service.OrderService;
import com.example.springmvcapp.model.Orders;
import com.example.springmvcapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderItemService orderItemService;

    @RequestMapping("/")
    public String home()
    {
        return "Welcome to my first spring web app";
    }

    @RequestMapping("/order/{id}")
    public OrderDTO returnOrder(@PathVariable int id) { return orderService.getOrder(id); }

    @RequestMapping("/product/{id}")
    public Optional<Products> returnProduct(@PathVariable int id)
    {
        return productService.getProduct(id);
    }

    @RequestMapping("/orderitem/{id}")
    public Optional<OrderItems> returnorderItem(@PathVariable Integer id){ return orderItemService.getorderItem(id); }

    @RequestMapping("/orders")
    public List<OrderDTO> returnallorders(){ return orderService.getallOrders();}

    @RequestMapping("/products")
    public List<Products> returnallproducts()
    {
        return productService.getallProducts();
    }

    @RequestMapping("/orderitems")
    public List<OrderItems> returnallorderitems(){ return orderItemService.getallOrderItems();}

    @RequestMapping(value = "/order/create", method = RequestMethod.POST)
    public String createOrder(@RequestBody OrderCreateDTO order){return orderService.createOrder(order);}

    @RequestMapping(value="/product/create",method=RequestMethod.POST)
    public String createProduct(@RequestBody Products product){return productService.createProduct(product);}


}
