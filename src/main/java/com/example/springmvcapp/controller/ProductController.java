package com.example.springmvcapp.controller;


import com.example.springmvcapp.dto.ProductResponseDTO;
import com.example.springmvcapp.model.Products;
import com.example.springmvcapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/products")
    public List<Products> returnAllProducts()
    {
        return productService.getAllProducts();
    }

    @RequestMapping("/product/{id}")
    public ProductResponseDTO returnProduct(@PathVariable int id)
    {
        return productService.getProduct(id);
    }

    @RequestMapping(value="/product/create",method= RequestMethod.POST)
    public String createProduct(@RequestBody Products product){return productService.createProduct(product);}

}
