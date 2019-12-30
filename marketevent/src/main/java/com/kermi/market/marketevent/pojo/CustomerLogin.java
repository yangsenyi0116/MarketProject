package com.kermi.market.marketevent.pojo;

import java.io.Serializable;
import java.util.Date;

public class CustomerLogin implements Serializable {
    private String customerId;

    private String loginName;

    private String password;

    private Byte userStats;

    private Date modifiedTime;

    private static final long serialVersionUID = 1L;

    public CustomerLogin(String customerId, String loginName, String password, Byte userStats, Date modifiedTime) {
        this.customerId = customerId;
        this.loginName = loginName;
        this.password = password;
        this.userStats = userStats;
        this.modifiedTime = modifiedTime;
    }

    public CustomerLogin() {
        super();
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Byte getUserStats() {
        return userStats;
    }

    public void setUserStats(Byte userStats) {
        this.userStats = userStats;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}