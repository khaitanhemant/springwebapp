package com.example.springmvcapp.repository;

import com.example.springmvcapp.model.OrderItems;
import com.example.springmvcapp.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItems, Integer>
{
    List<OrderItems> findByOrdid(String id);
}