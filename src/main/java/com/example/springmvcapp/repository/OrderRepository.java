package com.example.springmvcapp.repository;

import com.example.springmvcapp.model.Orders;
import com.example.springmvcapp.model.Products;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer>
{
}
