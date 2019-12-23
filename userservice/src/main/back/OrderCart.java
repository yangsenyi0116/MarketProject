package com.kermi.market.userservice.dao;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
public class OrderCart implements Serializable {
    private Integer cartId;

    private Integer customerId;

    private Integer productId;

    private Integer productAmount;

    private BigDecimal price;

    private Date addTime;

    private Date modifiedTime;

    private static final long serialVersionUID = 1L;

    public OrderCart() {
        super();
    }

}