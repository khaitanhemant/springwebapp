package com.example.springmvcapp.controller;


import com.example.springmvcapp.dto.ProductResponseDTO;
import com.example.springmvcapp.model.Product;
import com.example.springmvcapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("")
    public List<Product> returnAllProducts()
    {
        return productService.getAllProducts();
    }

    @RequestMapping("/{id}")
    public ProductResponseDTO returnProduct(@PathVariable int id)
    {
        ProductResponseDTO resProduct = productService.getProduct(id);
        if(resProduct!=null)
        {
            resProduct.setMessage("Success! Product found.");
            return resProduct;
        }
        else
        {
            resProduct.setMessage("Error: Product not found.");
            return resProduct;
        }
    }

    @RequestMapping(value="/create",method= RequestMethod.POST)
    public String createProduct(@RequestBody Product product){
        Product pro=productService.createProduct(product);
        return "Product "+pro.getProId()+" has been successfully added.";
    }

}
