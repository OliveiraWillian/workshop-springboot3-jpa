package com.willianoliveira.projetobeta.services;

import com.willianoliveira.projetobeta.entities.Category;
import com.willianoliveira.projetobeta.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        Category category = categoryRepository.findById(id).get();
        return category;
    }


    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }



}
