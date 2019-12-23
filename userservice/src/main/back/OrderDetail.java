package com.kermi.market.userservice.dao;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Data
@AllArgsConstructor
public class OrderDetail implements Serializable {
    private Integer orderDetailId;

    private Integer orderId;

    private Integer productId;

    private String productName;

    private Integer productCnt;

    private BigDecimal productPrice;

    private BigDecimal averageCost;

    private Float weight;

    private BigDecimal feeMoney;

    private Integer wId;

    private Date modifiedTime;

    private static final long serialVersionUID = 1L;

    public OrderDetail() {
        super();
    }

}