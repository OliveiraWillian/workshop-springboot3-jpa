package com.willianoliveira.projetobeta.repositories;

import com.willianoliveira.projetobeta.entities.Product;
import com.willianoliveira.projetobeta.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
