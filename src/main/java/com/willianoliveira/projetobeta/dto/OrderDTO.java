package com.willianoliveira.projetobeta.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.willianoliveira.projetobeta.entities.*;
import jakarta.persistence.*;
import org.springframework.beans.BeanUtils;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class OrderDTO {
    private Long id;
    private Instant moment;
    private Integer orderStatus;
    private UserDTO client;
    private Set<OrderItemDTO> items = new HashSet<>();
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private PaymentDTO payment;


    public OrderDTO() {
    }

    public OrderDTO(Order entity) {
        this.id = entity.getId();
        this.moment = entity.getMoment();
        this.orderStatus = entity.getOrderStatus().getCode();
        this.client = new UserDTO(entity.getClient());
        if (entity.getPayment() != null) {
            this.payment = new PaymentDTO(entity.getPayment());
        }
        if (entity.getItems() != null) {
            this.items = entity.getItems().stream()
                    .map(OrderItemDTO::new)
                    .collect(Collectors.toSet());
        }

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public UserDTO getClient() {
        return client;
    }

    public void setClient(UserDTO client) {
        this.client = client;
    }

    public Set<OrderItemDTO> getItems() {
        return items;
    }


    public PaymentDTO getPayment() {
        return payment;
    }

    public void setPayment(PaymentDTO payment) {
        this.payment = payment;
    }

    public void setItems(Set<OrderItemDTO> items) {
        this.items = items;
    }
    public Double getTotal() {
        double sum = 0.0;
        for(OrderItemDTO item : items) {
            sum += item.getSubTotal();
        }
        return sum;
    }
}
