package com.kermi.market.userservice.dao;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
public class BrandInfo implements Serializable {
    private Short brandId;

    private String brandName;

    private String telephone;

    private String brandWeb;

    private String brandLogo;

    private String brandDesc;

    private Byte brandStatus;

    private Byte brandOrder;

    private Date modifiedTime;

    private static final long serialVersionUID = 1L;

    public BrandInfo() {
        super();
    }
}