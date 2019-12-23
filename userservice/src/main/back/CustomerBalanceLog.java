package com.kermi.market.userservice.dao;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
public class CustomerBalanceLog implements Serializable {
    private Integer balanceId;

    private Integer customerId;

    private Byte source;

    private Integer sourceSn;

    private Date createTime;

    private BigDecimal amount;

    private static final long serialVersionUID = 1L;

    public CustomerBalanceLog() {
        super();
    }
}