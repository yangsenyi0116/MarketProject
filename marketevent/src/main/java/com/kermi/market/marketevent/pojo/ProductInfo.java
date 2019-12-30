package com.kermi.market.marketevent.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ProductInfo implements Serializable {
    private Integer productId;

    private String productCore;

    private String productName;

    private String barCode;

    private Integer brandId;

    private Short oneCategoryId;

    private Short twoCategoryId;

    private Short threeCategoryId;

    private Integer supplierId;

    private BigDecimal price;

    private BigDecimal averageCost;

    private Byte publishStatus;

    private Byte auditStatus;

    private Float weight;

    private Float length;

    private Float height;

    private Float width;

    private String colorType;

    private Date productionDate;

    private Integer shelfLife;

    private Date indate;

    private Date modifiedTime;

    private String descript;

    private static final long serialVersionUID = 1L;

    public ProductInfo(Integer productId, String productCore, String productName, String barCode, Integer brandId, Short oneCategoryId, Short twoCategoryId, Short threeCategoryId, Integer supplierId, BigDecimal price, BigDecimal averageCost, Byte publishStatus, Byte auditStatus, Float weight, Float length, Float height, Float width, String colorType, Date productionDate, Integer shelfLife, Date indate, Date modifiedTime, String descript) {
        this.productId = productId;
        this.productCore = productCore;
        this.productName = productName;
        this.barCode = barCode;
        this.brandId = brandId;
        this.oneCategoryId = oneCategoryId;
        this.twoCategoryId = twoCategoryId;
        this.threeCategoryId = threeCategoryId;
        this.supplierId = supplierId;
        this.price = price;
        this.averageCost = averageCost;
        this.publishStatus = publishStatus;
        this.auditStatus = auditStatus;
        this.weight = weight;
        this.length = length;
        this.height = height;
        this.width = width;
        this.colorType = colorType;
        this.productionDate = productionDate;
        this.shelfLife = shelfLife;
        this.indate = indate;
        this.modifiedTime = modifiedTime;
        this.descript = descript;
    }

    public ProductInfo() {
        super();
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductCore() {
        return productCore;
    }

    public void setProductCore(String productCore) {
        this.productCore = productCore == null ? null : productCore.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode == null ? null : barCode.trim();
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Short getOneCategoryId() {
        return oneCategoryId;
    }

    public void setOneCategoryId(Short oneCategoryId) {
        this.oneCategoryId = oneCategoryId;
    }

    public Short getTwoCategoryId() {
        return twoCategoryId;
    }

    public void setTwoCategoryId(Short twoCategoryId) {
        this.twoCategoryId = twoCategoryId;
    }

    public Short getThreeCategoryId() {
        return threeCategoryId;
    }

    public void setThreeCategoryId(Short threeCategoryId) {
        this.threeCategoryId = threeCategoryId;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getAverageCost() {
        return averageCost;
    }

    public void setAverageCost(BigDecimal averageCost) {
        this.averageCost = averageCost;
    }

    public Byte getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(Byte publishStatus) {
        this.publishStatus = publishStatus;
    }

    public Byte getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Byte auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getLength() {
        return length;
    }

    public void setLength(Float length) {
        this.length = length;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getWidth() {
        return width;
    }

    public void setWidth(Float width) {
        this.width = width;
    }

    public String getColorType() {
        return colorType;
    }

    public void setColorType(String colorType) {
        this.colorType = colorType == null ? null : colorType.trim();
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public Integer getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(Integer shelfLife) {
        this.shelfLife = shelfLife;
    }

    public Date getIndate() {
        return indate;
    }

    public void setIndate(Date indate) {
        this.indate = indate;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript == null ? null : descript.trim();
    }
}