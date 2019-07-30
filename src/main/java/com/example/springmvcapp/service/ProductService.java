package com.example.springmvcapp.service;

import com.example.springmvcapp.dto.ProductResponseDTO;
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

    public ProductResponseDTO getProduct(int id)
    {
        Optional<Products> product=productRepository.findById(id);
        ProductResponseDTO resProduct=new ProductResponseDTO();
        if(product.isPresent())
        {
            resProduct.setProduct(product.get());
            resProduct.setMessage("Success! Product found.");
            return resProduct;
        }
        else{
            resProduct.setMessage("Error: Product not found!");
            return resProduct;
        }
    }

    public List<Products> getAllProducts()
    {
        return productRepository.findAll();
    }

    public String createProduct(Products product){
        productRepository.save(product);
        return "Product "+product.getProId()+" has been successfully added";
    }
}
