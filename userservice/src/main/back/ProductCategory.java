package com.kermi.market.userservice.dao;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
@AllArgsConstructor
public class ProductCategory implements Serializable {
    private Short categoryId;

    private String categoryName;

    private String categoryCode;

    private Short parentId;

    private Byte categoryLevel;

    private Byte categoryStatus;

    private Date modifiedTime;

    private static final long serialVersionUID = 1L;

    public ProductCategory() {
        super();
    }

}