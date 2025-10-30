package com.myerp.esun.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productId;
    private Integer quantity;
    private String orderId;
    private Integer standPrice;
    private Integer itemPrice;

    public OrderEntity() {}

    public OrderEntity(String productId, Integer quantity,String orderId,Integer standPrice,Integer itemPrice) {
        this.productId = productId;
        this.quantity = quantity;
        this.orderId = orderId;
        this.standPrice = standPrice;
        this.itemPrice = itemPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getStandPrice() {
        return standPrice;
    }

    public void setStandPrice(Integer standPrice) {
        this.standPrice = standPrice;
    }

    public Integer getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Integer itemPrice) {
        this.itemPrice = itemPrice;
    }
}
