package com.example.binusezyfoody;

import java.io.Serializable;

public class Order extends Product implements Serializable {

    private Integer quantity;

    public Order(String name, Integer price, Integer quantity) {
        super(name, price);
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
