package com.kermi.market.userservice.entity;

import java.io.Serializable;
import java.util.Date;

public class CustomerAddr implements Serializable {
    private Integer customerAddrId;

    private String customerId;

    private Short zip;

    private String province;

    private String city;

    private String district;

    private String address;

    private Byte isDefault;

    private Date modifiedTime;

    private static final long serialVersionUID = 1L;

    public CustomerAddr(Integer customerAddrId, String customerId, Short zip, String province, String city, String district, String address, Byte isDefault, Date modifiedTime) {
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

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
    }

    public Short getZip() {
        return zip;
    }

    public void setZip(Short zip) {
        this.zip = zip;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
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