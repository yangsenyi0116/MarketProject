package com.kermi.market.marketevent.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ShippingInfo implements Serializable {
    private Byte shipId;

    private String shipName;

    private String shipContact;

    private String telephone;

    private BigDecimal price;

    private Date modifiedTime;

    private static final long serialVersionUID = 1L;

    public ShippingInfo(Byte shipId, String shipName, String shipContact, String telephone, BigDecimal price, Date modifiedTime) {
        this.shipId = shipId;
        this.shipName = shipName;
        this.shipContact = shipContact;
        this.telephone = telephone;
        this.price = price;
        this.modifiedTime = modifiedTime;
    }

    public ShippingInfo() {
        super();
    }

    public Byte getShipId() {
        return shipId;
    }

    public void setShipId(Byte shipId) {
        this.shipId = shipId;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName == null ? null : shipName.trim();
    }

    public String getShipContact() {
        return shipContact;
    }

    public void setShipContact(String shipContact) {
        this.shipContact = shipContact == null ? null : shipContact.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}