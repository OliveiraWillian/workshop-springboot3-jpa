package com.willianoliveira.projetobeta.dto;

import com.willianoliveira.projetobeta.entities.Order;
import com.willianoliveira.projetobeta.entities.Payment;
import org.springframework.beans.BeanUtils;

import java.time.Instant;

public class PaymentDTO {
    private Long id;
    private Instant moment;


    public PaymentDTO() {
    }
    public PaymentDTO(Payment entity) {
        this.id = entity.getId();
        this.moment = entity.getMoment();
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


}
