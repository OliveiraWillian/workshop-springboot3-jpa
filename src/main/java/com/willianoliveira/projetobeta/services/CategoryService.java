package com.willianoliveira.projetobeta.services;

import com.willianoliveira.projetobeta.dto.CategoryDTO;
import com.willianoliveira.projetobeta.dto.CategoryDTO;
import com.willianoliveira.projetobeta.entities.Category;
import com.willianoliveira.projetobeta.entities.Category;
import com.willianoliveira.projetobeta.exceptions.ResourceNotFoundException;
import com.willianoliveira.projetobeta.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryDTO save(CategoryDTO dto) {
        Category entity = new Category(dto);
        Category saved = categoryRepository.save(entity);
        return new CategoryDTO(saved);
    }


    public List<CategoryDTO> findAll() {
        List<Category> entity = categoryRepository.findAll();
        List<CategoryDTO> listDTO = entity.stream()
                .map(CategoryDTO::new)
                .collect(Collectors.toList());
        return listDTO;
    }

    public CategoryDTO findById(Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        Category category = categoryOptional.orElseThrow(() -> new ResourceNotFoundException(id));
        CategoryDTO categoryDTO = new CategoryDTO(category);
        return categoryDTO;
    }


    public void delete(Long id) {
        if (!categoryRepository.findById(id).isPresent()) {
            throw new ResourceNotFoundException(id);
        }
        categoryRepository.deleteById(id);
    }



}
