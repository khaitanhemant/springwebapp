package com.example.springmvcapp.service;

import com.example.springmvcapp.model.Products;
import com.example.springmvcapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Optional<Products> getProduct(String id)
    {
        return productRepository.findById(id);
    }

    public List<Products> getallProducts()
    {
        return productRepository.findAll();
    }
}
