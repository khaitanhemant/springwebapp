package com.example.springmvcapp.controller;


import com.example.springmvcapp.dto.GetProductDTO;
import com.example.springmvcapp.model.Product;
import com.example.springmvcapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("")
    public GetProductDTO returnAllProducts()
    {
        GetProductDTO resObj=new GetProductDTO();
        resObj.setProducts(productService.getAllProducts());
        if(!resObj.getProducts().isEmpty())
        {
            resObj.setMessage("All products returned");
        }
        else{
            resObj.setMessage("No products present");
        }
        return resObj;
    }

    @RequestMapping("/{ids}")
    public GetProductDTO returnProduct(@PathVariable List<Long> ids)
    {
        final GetProductDTO response = new GetProductDTO();
        response.setProducts(productService.getAllProductsById(ids));
        List<Long> dupIds = new ArrayList<>(ids);
        if (response.getProducts().isEmpty()) {
            response.setMessage("No products were found!");
        } else if (response.getProducts().size() < dupIds.size()) {
            for (Product product : response.getProducts()) {
                dupIds.remove(product.getProId());
            }
            response.setMessage("These products were not found :" + dupIds.toString());
        } else {
            response.setMessage("All products were found");
        }
        return response;
    }

    @RequestMapping(value="/create",method= RequestMethod.POST)
    public String createProduct(@RequestBody Product product){
        final Product pro=productService.createProduct(product);
        return "Product "+pro.getProId()+" has been successfully added.";
    }

}
