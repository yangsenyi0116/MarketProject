package com.kermi.market.marketevent.pojo;

import java.io.Serializable;
import java.util.Date;

public class ProductCategory implements Serializable {
    @Override
    public String toString() {
        return "ProductCategory{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", categoryCode='" + categoryCode + '\'' +
                ", parentId=" + parentId +
                ", categoryLevel=" + categoryLevel +
                ", categoryStatus=" + categoryStatus +
                ", modifiedTime=" + modifiedTime +
                '}';
    }

    private Short categoryId;

    private String categoryName;

    private String categoryCode;

    private Short parentId;

    private Byte categoryLevel;

    private Byte categoryStatus;

    private Date modifiedTime;

    private static final long serialVersionUID = 1L;

    public ProductCategory(Short categoryId, String categoryName, String categoryCode, Short parentId, Byte categoryLevel, Byte categoryStatus, Date modifiedTime) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryCode = categoryCode;
        this.parentId = parentId;
        this.categoryLevel = categoryLevel;
        this.categoryStatus = categoryStatus;
        this.modifiedTime = modifiedTime;
    }

    public ProductCategory() {
        super();
    }

    public Short getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Short categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode == null ? null : categoryCode.trim();
    }

    public Short getParentId() {
        return parentId;
    }

    public void setParentId(Short parentId) {
        this.parentId = parentId;
    }

    public Byte getCategoryLevel() {
        return categoryLevel;
    }

    public void setCategoryLevel(Byte categoryLevel) {
        this.categoryLevel = categoryLevel;
    }

    public Byte getCategoryStatus() {
        return categoryStatus;
    }

    public void setCategoryStatus(Byte categoryStatus) {
        this.categoryStatus = categoryStatus;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}