package com.example.springmvcapp.service;

import com.example.springmvcapp.dto.ProductResponseDTO;
import com.example.springmvcapp.model.Product;
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
        Optional<Product> product=productRepository.findById(id);
        ProductResponseDTO resProduct=new ProductResponseDTO();
        if(product.isPresent())
        {
            resProduct.setProduct(product.get());
            return resProduct;
        }
        else{
            return null;
        }
    }

    public List<Product> getAllProducts()
    {
        return productRepository.findAll();
    }

    // TODO should return ID - Done
    public Product createProduct(Product product){
        productRepository.save(product);
        return product;
    }
}
