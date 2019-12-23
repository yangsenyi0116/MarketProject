package com.kermi.market.userservice.dao;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Data
@AllArgsConstructor
public class WarehouseProduct implements Serializable {
    private Integer wpId;

    private Integer productId;

    private Short wId;

    private Integer currentCnt;

    private Integer lockCnt;

    private Integer inTransitCnt;

    private BigDecimal averageCost;

    private Date modifiedTime;

    private static final long serialVersionUID = 1L;

    public WarehouseProduct() {
        super();
    }

}