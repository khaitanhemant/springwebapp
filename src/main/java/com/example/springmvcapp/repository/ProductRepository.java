package com.example.springmvcapp.repository;


import com.example.springmvcapp.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Products, String>
{
}
