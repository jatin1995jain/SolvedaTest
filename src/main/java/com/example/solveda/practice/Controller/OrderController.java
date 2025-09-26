package com.example.solveda.practice.Controller;

import com.example.solveda.practice.dto.OrderRequest;
import com.example.solveda.practice.entity.Order;
import com.example.solveda.practice.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;


    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("with-payments")
    public Order createOrder(@RequestBody OrderRequest orderRequest) throws Exception {

        return orderService.placeOrder(orderRequest.getOrder(), orderRequest.getPaymentList());
    }
}
