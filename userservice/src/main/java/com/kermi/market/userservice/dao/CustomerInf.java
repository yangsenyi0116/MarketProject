package com.kermi.market.userservice.dao;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
public class CustomerInf implements Serializable {
    private Integer customerInfId;

    private String customerId;

    private String customerName;

    private Byte identityCardType;

    private String identityCardNo;

    private Integer mobilePhone;

    private String customerEmail;

    private String gender;

    private Integer userPoint;

    private Byte customerLevel;

    private BigDecimal userMoney;

    private Date registerTime;

    private Date modifiedTime;

    private static final long serialVersionUID = 1L;

    public CustomerInf() {
        super();
    }

}