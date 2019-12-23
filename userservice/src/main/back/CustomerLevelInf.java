package com.kermi.market.userservice.dao;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
public class CustomerLevelInf implements Serializable {
    private Byte customerLevel;

    private String levelName;

    private Integer minPoint;

    private Integer maxPoint;

    private Date modifiedTime;

    private static final long serialVersionUID = 1L;

    public CustomerLevelInf() {
        super();
    }
}