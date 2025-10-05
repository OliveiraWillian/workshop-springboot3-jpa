package com.willianoliveira.projetobeta.repositories;

import com.willianoliveira.projetobeta.entities.Category;
import com.willianoliveira.projetobeta.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
