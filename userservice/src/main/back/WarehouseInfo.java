package com.kermi.market.userservice.dao;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
@AllArgsConstructor
public class WarehouseInfo implements Serializable {
    private Short wId;

    private String warehouseSn;

    private String warehoustName;

    private String warehousePhone;

    private String contact;

    private Short province;

    private Short city;

    private Short distrct;

    private String address;

    private Byte warehouseStatus;

    private Date modifiedTime;

    private static final long serialVersionUID = 1L;

    public WarehouseInfo() {
        super();
    }
}