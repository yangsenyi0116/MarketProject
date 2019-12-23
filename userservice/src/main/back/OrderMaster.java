package com.kermi.market.userservice.dao;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
public class OrderMaster implements Serializable {
    private Integer orderId;

    private Long orderSn;

    private Integer customerId;

    private String shippingUser;

    private Short province;

    private Short city;

    private Short district;

    private String address;

    private Byte paymentMethod;

    private BigDecimal orderMoney;

    private BigDecimal districtMoney;

    private BigDecimal shippingMoney;

    private BigDecimal paymentMoney;

    private String shippingCompName;

    private String shippingSn;

    private Date createTime;

    private Date shippingTime;

    private Date payTime;

    private Date receiveTime;

    private Byte orderStatus;

    private Integer orderPoint;

    private String invoiceTime;

    private Date modifiedTime;

    private static final long serialVersionUID = 1L;

    public OrderMaster() {
        super();
    }

}