package com.willianoliveira.projetobeta.services;

import com.willianoliveira.projetobeta.entities.Order;
import com.willianoliveira.projetobeta.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
        Order order = orderRepository.findById(id).get();
        return order;
    }


    public void delete(Long id) {
        orderRepository.deleteById(id);
    }





}
