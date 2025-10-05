package com.willianoliveira.projetobeta.enums;

import java.util.zip.DataFormatException;

public enum OrderStatus {
    WAITING_PAYMENT(1),
    PAID(2),
    Shipping(3),
    DELIVERED(4),
    CANCELLED(5);

    public int code;
    private OrderStatus(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }
    public static OrderStatus getOrderStatus(int code) {
        for(OrderStatus orderStatus : OrderStatus.values()) {
            if(orderStatus.code == code){
                return orderStatus;
            }
        }
        throw new RuntimeException("Erro ao obter o status do OrderStatus");
    }
}
