package com.kermi.market.userservice.dao;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
@AllArgsConstructor
public class CustomerLogin implements Serializable {
    private String customerId;

    private String loginName;

    private String password;

    private Byte userStats;

    private Date modifiedTime;

    private static final long serialVersionUID = 1L;

    public CustomerLogin() {
        super();
    }

}