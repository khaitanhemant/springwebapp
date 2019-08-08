package com.example.springmvcapp.repository;

import com.example.springmvcapp.model.OrderEntity;
import com.example.springmvcapp.model.OrderItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrderRepository extends PagingAndSortingRepository<OrderEntity, Long>,JpaRepository<OrderEntity,Long>
{
//    List<OrderEntity> getAllByOrderDateBetween(LocalDate from, LocalDate to);
    Page<OrderEntity> getAllByOrderDateBetween(LocalDate from,LocalDate to,Pageable paging);
}
