package com.example.springmvcapp.repository;

import com.example.springmvcapp.model.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItems, Integer>
{
    List<OrderItems> findByOrdId(int id);
}