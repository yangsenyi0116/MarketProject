package com.kermi.market.marketevent.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CustomerBalanceLog implements Serializable {
    private Integer balanceId;

    private Integer customerId;

    private Byte source;

    private Integer sourceSn;

    private Date createTime;

    private BigDecimal amount;

    private static final long serialVersionUID = 1L;

    public CustomerBalanceLog(Integer balanceId, Integer customerId, Byte source, Integer sourceSn, Date createTime, BigDecimal amount) {
        this.balanceId = balanceId;
        this.customerId = customerId;
        this.source = source;
        this.sourceSn = sourceSn;
        this.createTime = createTime;
        this.amount = amount;
    }

    public CustomerBalanceLog() {
        super();
    }

    public Integer getBalanceId() {
        return balanceId;
    }

    public void setBalanceId(Integer balanceId) {
        this.balanceId = balanceId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Byte getSource() {
        return source;
    }

    public void setSource(Byte source) {
        this.source = source;
    }

    public Integer getSourceSn() {
        return sourceSn;
    }

    public void setSourceSn(Integer sourceSn) {
        this.sourceSn = sourceSn;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}