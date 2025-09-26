package com.example.solveda.practice.dto;

import com.example.solveda.practice.entity.Order;
import com.example.solveda.practice.entity.Payment;

import java.util.List;

public class OrderRequest {

    private Order order;
    private List<Payment> paymentList;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }
}
