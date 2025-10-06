package com.willianoliveira.projetobeta.repositories;

import com.willianoliveira.projetobeta.entities.OrderItem;
import com.willianoliveira.projetobeta.entities.OrderItemPK;
import com.willianoliveira.projetobeta.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}
