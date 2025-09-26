package com.example.solveda.practice.repository;

import com.example.solveda.practice.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<Payment, Long> {

}
