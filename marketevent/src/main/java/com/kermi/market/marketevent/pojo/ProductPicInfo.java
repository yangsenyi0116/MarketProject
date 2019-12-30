package com.kermi.market.marketevent.pojo;

import java.io.Serializable;
import java.util.Date;

public class ProductPicInfo implements Serializable {
    private Integer productPicId;

    private Integer productId;

    private String picDesc;

    private String picUrl;

    private Byte isMaster;

    private Byte picOrder;

    private Byte picStatus;

    private Date modifiedTime;

    private static final long serialVersionUID = 1L;

    public ProductPicInfo(Integer productPicId, Integer productId, String picDesc, String picUrl, Byte isMaster, Byte picOrder, Byte picStatus, Date modifiedTime) {
        this.productPicId = productPicId;
        this.productId = productId;
        this.picDesc = picDesc;
        this.picUrl = picUrl;
        this.isMaster = isMaster;
        this.picOrder = picOrder;
        this.picStatus = picStatus;
        this.modifiedTime = modifiedTime;
    }

    public ProductPicInfo() {
        super();
    }

    public Integer getProductPicId() {
        return productPicId;
    }

    public void setProductPicId(Integer productPicId) {
        this.productPicId = productPicId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getPicDesc() {
        return picDesc;
    }

    public void setPicDesc(String picDesc) {
        this.picDesc = picDesc == null ? null : picDesc.trim();
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    public Byte getIsMaster() {
        return isMaster;
    }

    public void setIsMaster(Byte isMaster) {
        this.isMaster = isMaster;
    }

    public Byte getPicOrder() {
        return picOrder;
    }

    public void setPicOrder(Byte picOrder) {
        this.picOrder = picOrder;
    }

    public Byte getPicStatus() {
        return picStatus;
    }

    public void setPicStatus(Byte picStatus) {
        this.picStatus = picStatus;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}