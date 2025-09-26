package com.example.solveda.practice.service;

import com.example.solveda.practice.entity.Order;
import com.example.solveda.practice.entity.Payment;
import com.example.solveda.practice.repository.OrderRepo;
import com.example.solveda.practice.repository.PaymentRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepo orderRepository;
    private final PaymentRepo paymentRepository;

    public OrderService(OrderRepo orderRepository,
                        PaymentRepo paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }

    /*
    * This method will take care of acid properties as ACID means atomicity, consistency, integrity and
    * durability
    *
    * In case any of the save db call fails then all the calls made before that also gets failed and will not be
    * committed to the db,
    * Either all the save db calls get success or one will be successful
    * */
    @Transactional
    public Order placeOrder(Order order, List<Payment> payments) throws Exception {

        if(order == null || CollectionUtils.isEmpty(payments)) throw new Exception("Order or payment is empty");
        // Save order first
        Order savedOrder = orderRepository.save(order);

        // Save all payments linked to the order
        for (Payment payment : payments) {
            payment.setOrder(savedOrder);
            paymentRepository.save(payment);
        }
        savedOrder.getPayments();
        return savedOrder;
    }
}
