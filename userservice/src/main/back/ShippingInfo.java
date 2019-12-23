package com.kermi.market.userservice.dao;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Data
@AllArgsConstructor
public class ShippingInfo implements Serializable {
    private Byte shipId;

    private String shipName;

    private String shipContact;

    private String telephone;

    private BigDecimal price;

    private Date modifiedTime;

    private static final long serialVersionUID = 1L;

    public ShippingInfo() {
        super();
    }

}