package com.kermi.market.goodsservice.dao;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
@AllArgsConstructor
public class ProductCategory implements Serializable {
    /*分类ID*/
    private Short categoryId;
    /*分类名称*/
    private String categoryName;
    /*分类编码*/
    private String categoryCode;
    /*父分类ID*/
    private Short parentId;
    /*分类级层*/
    private Byte categoryLevel;
    /*分类状态*/
    private Byte categoryStatus;
    /*最后修改时间*/
    private Date modifiedTime;

    private static final long serialVersionUID = 1L;

    public ProductCategory() {
        super();
    }

}