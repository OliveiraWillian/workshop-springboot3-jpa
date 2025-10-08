package com.willianoliveira.projetobeta.controllers;

import com.willianoliveira.projetobeta.dto.ProductDTO;
import com.willianoliveira.projetobeta.entities.Product;
import com.willianoliveira.projetobeta.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll(){
        List<ProductDTO> productList = productService.findAll();
        return ResponseEntity.ok().body(productList);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id){
        ProductDTO productSelect = productService.findById(id);
        return ResponseEntity.ok().body(productSelect);
    }
}
