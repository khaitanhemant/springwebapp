package com.example.springmvcapp.repository;

import com.example.springmvcapp.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long>
{
    List<OrderEntity> getAllByOrderDateBetween(LocalDate from, LocalDate to);
}
