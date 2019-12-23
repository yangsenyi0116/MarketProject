package com.kermi.market.userservice.dao;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
public class CustomerAddr implements Serializable {
    private Integer customerAddrId;

    private String customerId;

    private Integer zip;

    private String province;

    private String city;

    private String district;

    private String address;

    private Byte isDefault;

    private Date modifiedTime;

    private static final long serialVersionUID = 1L;

    public CustomerAddr() {
        super();
    }
}