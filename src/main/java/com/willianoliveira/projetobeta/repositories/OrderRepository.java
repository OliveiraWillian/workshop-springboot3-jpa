package com.willianoliveira.projetobeta.repositories;

import com.willianoliveira.projetobeta.entities.Order;
import com.willianoliveira.projetobeta.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
