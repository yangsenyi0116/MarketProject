package com.kermi.market.userservice.dao;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
@AllArgsConstructor
public class CustomerLoginLog implements Serializable {
    private Integer loginId;

    private String customerId;

    private Date loginTime;

    private Integer loginIp;

    private Byte loginType;

    private static final long serialVersionUID = 1L;

    public CustomerLoginLog() {
        super();
    }

}