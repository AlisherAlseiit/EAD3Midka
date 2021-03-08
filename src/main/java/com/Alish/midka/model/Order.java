package com.Alish.midka.model;

public class Order {
    private  Long orderId;
    private Long registration_id;
    private Long product_id;
    private String buyerName;
    private String productName;


    public Order() {
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getRegistration_id() {
        return registration_id;
    }

    public void setRegistration_id(Long registration_id) {
        this.registration_id = registration_id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
