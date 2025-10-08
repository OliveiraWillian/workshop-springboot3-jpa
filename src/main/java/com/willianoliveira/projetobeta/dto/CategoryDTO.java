package com.willianoliveira.projetobeta.dto;

import com.willianoliveira.projetobeta.entities.Category;
import org.springframework.beans.BeanUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class CategoryDTO {
    private Long id;
    private String name;


    public CategoryDTO() {
    }
    public CategoryDTO(Category entity) {
        this.id = entity.getId();
        this.name = entity.getName();


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
