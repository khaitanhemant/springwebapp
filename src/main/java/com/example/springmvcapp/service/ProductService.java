package com.example.springmvcapp.service;

import com.example.springmvcapp.dto.GetProductDTO;
import com.example.springmvcapp.model.Product;
import com.example.springmvcapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getAllProductsById(List<Long> ids){ return productRepository.findAllById(ids);}


    public Product createProduct(Product product) {
        productRepository.save(product);
        return product;
    }
}
