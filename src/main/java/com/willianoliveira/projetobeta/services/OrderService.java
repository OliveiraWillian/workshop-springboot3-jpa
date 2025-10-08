package com.willianoliveira.projetobeta.services;

import com.willianoliveira.projetobeta.dto.OrderDTO;
import com.willianoliveira.projetobeta.dto.OrderDTO;
import com.willianoliveira.projetobeta.dto.OrderDTO;
import com.willianoliveira.projetobeta.entities.Order;
import com.willianoliveira.projetobeta.entities.Order;
import com.willianoliveira.projetobeta.entities.Order;
import com.willianoliveira.projetobeta.entities.Order;
import com.willianoliveira.projetobeta.exceptions.ResourceNotFoundException;
import com.willianoliveira.projetobeta.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public OrderDTO save(OrderDTO dto) {
        Order entity = new Order(dto);
        Order saved = orderRepository.save(entity);
        return new OrderDTO(saved);
    }

    public List<OrderDTO> findAll() {
        List<Order> entity = orderRepository.findAll();
        List<OrderDTO> listDTO = entity.stream()
                .map(OrderDTO::new)
                .collect(Collectors.toList());
        return listDTO;
    }

    public OrderDTO findById(Long id) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        Order order = orderOptional.orElseThrow(() -> new ResourceNotFoundException(id));
        OrderDTO orderDTO = new OrderDTO(order);
        return orderDTO;
    }


    public void delete(Long id) {
        if (!orderRepository.findById(id).isPresent()) {
            throw new ResourceNotFoundException(id);
        }
        orderRepository.deleteById(id);
    }





}
