package com.willianoliveira.projetobeta.services;

import com.willianoliveira.projetobeta.entities.Product;
import com.willianoliveira.projetobeta.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        Product product = productRepository.findById(id).get();
        return product;
    }


    public void delete(Long id) {
        productRepository.deleteById(id);
    }


}
