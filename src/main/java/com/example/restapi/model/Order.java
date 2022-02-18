package com.example.restapi.model;

import javax.persistence.*;

@Entity(name="user_order")
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    private String item;

    private Integer quantity;

    public Order(){}

    public Order(String item, Integer quantity){
        this.item = item;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getItem() {
        return item;
    }
    public void setItem(String item) {
        this.item = item;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
