package com.willianoliveira.projetobeta.dto;

import com.willianoliveira.projetobeta.entities.Order;
import com.willianoliveira.projetobeta.entities.OrderItem;
import com.willianoliveira.projetobeta.entities.OrderItemPK;
import org.springframework.beans.BeanUtils;

public class OrderItemDTO {
    private ProductDTO product; // ← Direto, sem PK
    private Integer quantity;
    private Double price;

    public OrderItemDTO() {}

    public OrderItemDTO(OrderItem entity) {
        this.quantity = entity.getQuantity();
        this.price = entity.getPrice();

        // Acesso direto ao product
        if (entity.getId() != null && entity.getId().getProduct() != null) {
            this.product = new ProductDTO(entity.getId().getProduct());
        }
    }

    // Getters e Setters SIMPLES
    public ProductDTO getProduct() { return product; }
    public void setProduct(ProductDTO product) { this.product = product; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public Double getSubTotal() {
        return price * quantity;
    }
}

