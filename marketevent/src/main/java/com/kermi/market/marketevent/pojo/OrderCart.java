package com.kermi.market.marketevent.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OrderCart implements Serializable {
    private Integer cartId;

    private Integer customerId;

    private Integer productId;

    private Integer productAmount;

    private BigDecimal price;

    private Date addTime;

    private Date modifiedTime;

    private static final long serialVersionUID = 1L;

    public OrderCart(Integer cartId, Integer customerId, Integer productId, Integer productAmount, BigDecimal price, Date addTime, Date modifiedTime) {
        this.cartId = cartId;
        this.customerId = customerId;
        this.productId = productId;
        this.productAmount = productAmount;
        this.price = price;
        this.addTime = addTime;
        this.modifiedTime = modifiedTime;
    }

    public OrderCart() {
        super();
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(Integer productAmount) {
        this.productAmount = productAmount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}