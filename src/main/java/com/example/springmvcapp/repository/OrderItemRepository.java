package com.example.springmvcapp.repository;

import com.example.springmvcapp.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long>, PagingAndSortingRepository<OrderItem,Long>
{
    List<OrderItem> findOrderItemsByOrdIdIn(List<Long> ids);
}