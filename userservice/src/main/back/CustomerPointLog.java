package com.kermi.market.userservice.dao;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
public class CustomerPointLog implements Serializable {
    private Integer pointId;

    private Integer customerId;

    private Byte source;

    private Integer referNumber;

    private Short changePoint;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public CustomerPointLog() {
        super();
    }

}