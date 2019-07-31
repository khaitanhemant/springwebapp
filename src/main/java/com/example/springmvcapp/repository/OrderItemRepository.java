package com.example.springmvcapp.repository;

import com.example.springmvcapp.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer>
{
    List<OrderItem> findByOrdId(int id);
}