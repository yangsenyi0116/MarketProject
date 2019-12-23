package com.kermi.market.goodsservice.dao;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Data
@AllArgsConstructor
public class ProductInfo implements Serializable {
    private Integer productId;

    private String productCore;

    private String productName;

    private String barCode;

    private Integer brandId;

    private Short oneCategoryId;

    private Short twoCategoryId;

    private Short threeCategoryId;

    private Integer supplierId;

    private BigDecimal price;

    private BigDecimal averageCost;

    private Byte publishStatus;

    private Byte auditStatus;

    private Float weight;

    private Float length;

    private Float height;

    private Float width;

    private String colorType;

    private Date productionDate;

    private Integer shelfLife;

    private Date indate;

    private Date modifiedTime;

    private String descript;

    private static final long serialVersionUID = 1L;

    public ProductInfo() {
        super();
    }

}