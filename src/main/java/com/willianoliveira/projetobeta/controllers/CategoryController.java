package com.willianoliveira.projetobeta.controllers;

import com.willianoliveira.projetobeta.entities.Category;
import com.willianoliveira.projetobeta.entities.User;
import com.willianoliveira.projetobeta.services.CategoryService;
import com.willianoliveira.projetobeta.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/categorys")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Category findById(@PathVariable Long id) {
        return categoryService.findById(id);
    }
}
