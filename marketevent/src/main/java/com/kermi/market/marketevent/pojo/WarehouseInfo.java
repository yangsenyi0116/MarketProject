package com.kermi.market.marketevent.pojo;

import java.io.Serializable;
import java.util.Date;

public class WarehouseInfo implements Serializable {
    private Short wId;

    private String warehouseSn;

    private String warehoustName;

    private String warehousePhone;

    private String contact;

    private Short province;

    private Short city;

    private Short distrct;

    private String address;

    private Byte warehouseStatus;

    private Date modifiedTime;

    private static final long serialVersionUID = 1L;

    public WarehouseInfo(Short wId, String warehouseSn, String warehoustName, String warehousePhone, String contact, Short province, Short city, Short distrct, String address, Byte warehouseStatus, Date modifiedTime) {
        this.wId = wId;
        this.warehouseSn = warehouseSn;
        this.warehoustName = warehoustName;
        this.warehousePhone = warehousePhone;
        this.contact = contact;
        this.province = province;
        this.city = city;
        this.distrct = distrct;
        this.address = address;
        this.warehouseStatus = warehouseStatus;
        this.modifiedTime = modifiedTime;
    }

    public WarehouseInfo() {
        super();
    }

    public Short getwId() {
        return wId;
    }

    public void setwId(Short wId) {
        this.wId = wId;
    }

    public String getWarehouseSn() {
        return warehouseSn;
    }

    public void setWarehouseSn(String warehouseSn) {
        this.warehouseSn = warehouseSn == null ? null : warehouseSn.trim();
    }

    public String getWarehoustName() {
        return warehoustName;
    }

    public void setWarehoustName(String warehoustName) {
        this.warehoustName = warehoustName == null ? null : warehoustName.trim();
    }

    public String getWarehousePhone() {
        return warehousePhone;
    }

    public void setWarehousePhone(String warehousePhone) {
        this.warehousePhone = warehousePhone == null ? null : warehousePhone.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
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

    public Short getDistrct() {
        return distrct;
    }

    public void setDistrct(Short distrct) {
        this.distrct = distrct;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Byte getWarehouseStatus() {
        return warehouseStatus;
    }

    public void setWarehouseStatus(Byte warehouseStatus) {
        this.warehouseStatus = warehouseStatus;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}