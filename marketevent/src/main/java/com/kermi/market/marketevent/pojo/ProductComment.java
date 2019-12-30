package com.kermi.market.marketevent.pojo;

import java.io.Serializable;
import java.util.Date;

public class ProductComment implements Serializable {
    private Integer commentId;

    private Integer productId;

    private Long orderId;

    private Integer customerId;

    private String title;

    private String content;

    private Byte auditStatus;

    private Date auditTime;

    private Date modifiedTime;

    private static final long serialVersionUID = 1L;

    public ProductComment(Integer commentId, Integer productId, Long orderId, Integer customerId, String title, String content, Byte auditStatus, Date auditTime, Date modifiedTime) {
        this.commentId = commentId;
        this.productId = productId;
        this.orderId = orderId;
        this.customerId = customerId;
        this.title = title;
        this.content = content;
        this.auditStatus = auditStatus;
        this.auditTime = auditTime;
        this.modifiedTime = modifiedTime;
    }

    public ProductComment() {
        super();
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Byte getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Byte auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}