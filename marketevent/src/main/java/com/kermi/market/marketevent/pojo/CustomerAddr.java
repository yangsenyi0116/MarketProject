package com.kermi.market.marketevent.pojo;

import java.io.Serializable;
import java.util.Date;

public class CustomerAddr implements Serializable {
    private Integer customerAddrId;

    private Integer customerId;

    private Short zip;

    private Short province;

    private Short city;

    private Short district;

    private String address;

    private Byte isDefault;

    private Date modifiedTime;

    private static final long serialVersionUID = 1L;

    public CustomerAddr(Integer customerAddrId, Integer customerId, Short zip, Short province, Short city, Short district, String address, Byte isDefault, Date modifiedTime) {
        this.customerAddrId = customerAddrId;
        this.customerId = customerId;
        this.zip = zip;
        this.province = province;
        this.city = city;
        this.district = district;
        this.address = address;
        this.isDefault = isDefault;
        this.modifiedTime = modifiedTime;
    }

    public CustomerAddr() {
        super();
    }

    public Integer getCustomerAddrId() {
        return customerAddrId;
    }

    public void setCustomerAddrId(Integer customerAddrId) {
        this.customerAddrId = customerAddrId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Short getZip() {
        return zip;
    }

    public void setZip(Short zip) {
        this.zip = zip;
    }

    public Short getProvince() {
        return province;
    }

    public void setProvince(Short province) {
        this.province = province;
    }

    public Short getCity() {
        return city;
    }

    public void setCity(Short city) {
        this.city = city;
    }

    public Short getDistrict() {
        return district;
    }

    public void setDistrict(Short district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Byte getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Byte isDefault) {
        this.isDefault = isDefault;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}