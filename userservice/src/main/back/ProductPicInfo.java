package com.kermi.market.userservice.dao;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
@AllArgsConstructor
public class ProductPicInfo implements Serializable {
    private Integer productPicId;

    private Integer productId;

    private String picDesc;

    private String picUrl;

    private Byte isMaster;

    private Byte picOrder;

    private Byte picStatus;

    private Date modifiedTime;

    private static final long serialVersionUID = 1L;

    public ProductPicInfo() {
        super();
    }
}