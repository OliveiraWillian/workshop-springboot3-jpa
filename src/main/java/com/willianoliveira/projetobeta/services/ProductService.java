package com.willianoliveira.projetobeta.services;

import com.willianoliveira.projetobeta.dto.ProductDTO;
import com.willianoliveira.projetobeta.dto.ProductDTO;
import com.willianoliveira.projetobeta.entities.Product;
import com.willianoliveira.projetobeta.entities.Product;
import com.willianoliveira.projetobeta.entities.Product;
import com.willianoliveira.projetobeta.entities.User;
import com.willianoliveira.projetobeta.exceptions.ResourceNotFoundException;
import com.willianoliveira.projetobeta.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ProductDTO save(ProductDTO dto) {
        Product entity = new Product(dto);
        Product saved = productRepository.save(entity);
        return new ProductDTO(saved);
    }

    public List<ProductDTO> findAll() {
        List<Product> entity = productRepository.findAll();
        List<ProductDTO> listDTO = entity.stream()
                .map(ProductDTO::new)
                .collect(Collectors.toList());
        return listDTO;
    }

    public ProductDTO findById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        Product product = productOptional.orElseThrow(() -> new ResourceNotFoundException(id));
        ProductDTO productDTO = new ProductDTO(product);
        return productDTO;
    }


    public void delete(Long id) {
        if (!productRepository.findById(id).isPresent()) {
            throw new ResourceNotFoundException(id);
        }
        productRepository.deleteById(id);
    }


}
