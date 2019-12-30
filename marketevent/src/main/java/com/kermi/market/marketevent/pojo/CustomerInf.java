package com.kermi.market.marketevent.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CustomerInf implements Serializable {
    private Integer customerInfId;

    private String customerId;

    private String customerName;

    private Byte identityCardType;

    private String identityCardNo;

    private Integer mobilePhone;

    private String customerEmail;

    private String gender;

    private Integer userPoint;

    private Byte customerLevel;

    private BigDecimal userMoney;

    private Date registerTime;

    private Date modifiedTime;

    private static final long serialVersionUID = 1L;

    public CustomerInf(Integer customerInfId, String customerId, String customerName, Byte identityCardType, String identityCardNo, Integer mobilePhone, String customerEmail, String gender, Integer userPoint, Byte customerLevel, BigDecimal userMoney, Date registerTime, Date modifiedTime) {
        this.customerInfId = customerInfId;
        this.customerId = customerId;
        this.customerName = customerName;
        this.identityCardType = identityCardType;
        this.identityCardNo = identityCardNo;
        this.mobilePhone = mobilePhone;
        this.customerEmail = customerEmail;
        this.gender = gender;
        this.userPoint = userPoint;
        this.customerLevel = customerLevel;
        this.userMoney = userMoney;
        this.registerTime = registerTime;
        this.modifiedTime = modifiedTime;
    }

    public CustomerInf() {
        super();
    }

    public Integer getCustomerInfId() {
        return customerInfId;
    }

    public void setCustomerInfId(Integer customerInfId) {
        this.customerInfId = customerInfId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public Byte getIdentityCardType() {
        return identityCardType;
    }

    public void setIdentityCardType(Byte identityCardType) {
        this.identityCardType = identityCardType;
    }

    public String getIdentityCardNo() {
        return identityCardNo;
    }

    public void setIdentityCardNo(String identityCardNo) {
        this.identityCardNo = identityCardNo == null ? null : identityCardNo.trim();
    }

    public Integer getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(Integer mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail == null ? null : customerEmail.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public Integer getUserPoint() {
        return userPoint;
    }

    public void setUserPoint(Integer userPoint) {
        this.userPoint = userPoint;
    }

    public Byte getCustomerLevel() {
        return customerLevel;
    }

    public void setCustomerLevel(Byte customerLevel) {
        this.customerLevel = customerLevel;
    }

    public BigDecimal getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(BigDecimal userMoney) {
        this.userMoney = userMoney;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}