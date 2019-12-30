package com.kermi.market.marketevent.pojo;

import java.io.Serializable;
import java.util.Date;

public class CustomerPointLog implements Serializable {
    private Integer pointId;

    private Integer customerId;

    private Byte source;

    private Integer referNumber;

    private Short changePoint;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public CustomerPointLog(Integer pointId, Integer customerId, Byte source, Integer referNumber, Short changePoint, Date createTime) {
        this.pointId = pointId;
        this.customerId = customerId;
        this.source = source;
        this.referNumber = referNumber;
        this.changePoint = changePoint;
        this.createTime = createTime;
    }

    public CustomerPointLog() {
        super();
    }

    public Integer getPointId() {
        return pointId;
    }

    public void setPointId(Integer pointId) {
        this.pointId = pointId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Byte getSource() {
        return source;
    }

    public void setSource(Byte source) {
        this.source = source;
    }

    public Integer getReferNumber() {
        return referNumber;
    }

    public void setReferNumber(Integer referNumber) {
        this.referNumber = referNumber;
    }

    public Short getChangePoint() {
        return changePoint;
    }

    public void setChangePoint(Short changePoint) {
        this.changePoint = changePoint;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}