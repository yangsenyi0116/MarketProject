package com.kermi.market.userservice.dao;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
@AllArgsConstructor
public class SupplierInfo implements Serializable {
    private Integer supplierId;

    private String supplierCode;

    private String supplierName;

    private Byte supplierType;

    private String linkMan;

    private String phoneNumber;

    private String bankName;

    private String bankAccount;

    private String address;

    private Byte supplierStatus;

    private Date modifiedTime;

    private static final long serialVersionUID = 1L;

    public SupplierInfo() {
        super();
    }

}