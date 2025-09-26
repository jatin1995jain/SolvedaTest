package com.example.solveda.practice.repository;

import com.example.solveda.practice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Long> {
}
