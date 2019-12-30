package com.kermi.market.marketevent.pojo;

import java.io.Serializable;
import java.util.Date;

public class CustomerLevelInf implements Serializable {
    private Byte customerLevel;

    private String levelName;

    private Integer minPoint;

    private Integer maxPoint;

    private Date modifiedTime;

    private static final long serialVersionUID = 1L;

    public CustomerLevelInf(Byte customerLevel, String levelName, Integer minPoint, Integer maxPoint, Date modifiedTime) {
        this.customerLevel = customerLevel;
        this.levelName = levelName;
        this.minPoint = minPoint;
        this.maxPoint = maxPoint;
        this.modifiedTime = modifiedTime;
    }

    public CustomerLevelInf() {
        super();
    }

    public Byte getCustomerLevel() {
        return customerLevel;
    }

    public void setCustomerLevel(Byte customerLevel) {
        this.customerLevel = customerLevel;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName == null ? null : levelName.trim();
    }

    public Integer getMinPoint() {
        return minPoint;
    }

    public void setMinPoint(Integer minPoint) {
        this.minPoint = minPoint;
    }

    public Integer getMaxPoint() {
        return maxPoint;
    }

    public void setMaxPoint(Integer maxPoint) {
        this.maxPoint = maxPoint;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}