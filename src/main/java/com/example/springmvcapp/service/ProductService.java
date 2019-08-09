package com.example.springmvcapp.service;

import com.example.springmvcapp.dto.GetProductDTO;
import com.example.springmvcapp.model.Product;
import com.example.springmvcapp.repository.ProductRepository;
import com.oracle.tools.packager.Log;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class ProductService {
    Logger log= LoggerFactory.getLogger(getClass());

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(Integer pageNo, Integer pageSize) {
        Page<Product> pagedResult=productRepository.findAll(PageRequest.of(pageNo,pageSize));
        return pagedResult.getContent();
    }

    @Cacheable(value = "products", key = "#ids")
    public List<Product> getAllProductsById(List<Long> ids){
        log.info("Getting products with IDs:" +ids);
        return productRepository.findAllById(ids);
    }


    public Product createProduct(Product product) {
        productRepository.save(product);
        return product;
    }
}
