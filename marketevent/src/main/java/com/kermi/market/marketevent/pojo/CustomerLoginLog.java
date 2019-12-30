package com.kermi.market.marketevent.pojo;

import java.io.Serializable;
import java.util.Date;

public class CustomerLoginLog implements Serializable {
    private Integer loginId;

    private Integer customerId;

    private Date loginTime;

    private Integer loginIp;

    private Byte loginType;

    private static final long serialVersionUID = 1L;

    public CustomerLoginLog(Integer loginId, Integer customerId, Date loginTime, Integer loginIp, Byte loginType) {
        this.loginId = loginId;
        this.customerId = customerId;
        this.loginTime = loginTime;
        this.loginIp = loginIp;
        this.loginType = loginType;
    }

    public CustomerLoginLog() {
        super();
    }

    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Integer getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(Integer loginIp) {
        this.loginIp = loginIp;
    }

    public Byte getLoginType() {
        return loginType;
    }

    public void setLoginType(Byte loginType) {
        this.loginType = loginType;
    }
}