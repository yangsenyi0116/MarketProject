package com.kermi.market.marketevent.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OrderMaster implements Serializable {
    private Integer orderId;

    private Long orderSn;

    private Integer customerId;

    private String shippingUser;

    private Short province;

    private Short city;

    private Short district;

    private String address;

    private Byte paymentMethod;

    private BigDecimal orderMoney;

    private BigDecimal districtMoney;

    private BigDecimal shippingMoney;

    private BigDecimal paymentMoney;

    private String shippingCompName;

    private String shippingSn;

    private Date createTime;

    private Date shippingTime;

    private Date payTime;

    private Date receiveTime;

    private Byte orderStatus;

    private Integer orderPoint;

    private String invoiceTime;

    private Date modifiedTime;

    private static final long serialVersionUID = 1L;

    public OrderMaster(Integer orderId, Long orderSn, Integer customerId, String shippingUser, Short province, Short city, Short district, String address, Byte paymentMethod, BigDecimal orderMoney, BigDecimal districtMoney, BigDecimal shippingMoney, BigDecimal paymentMoney, String shippingCompName, String shippingSn, Date createTime, Date shippingTime, Date payTime, Date receiveTime, Byte orderStatus, Integer orderPoint, String invoiceTime, Date modifiedTime) {
        this.orderId = orderId;
        this.orderSn = orderSn;
        this.customerId = customerId;
        this.shippingUser = shippingUser;
        this.province = province;
        this.city = city;
        this.district = district;
        this.address = address;
        this.paymentMethod = paymentMethod;
        this.orderMoney = orderMoney;
        this.districtMoney = districtMoney;
        this.shippingMoney = shippingMoney;
        this.paymentMoney = paymentMoney;
        this.shippingCompName = shippingCompName;
        this.shippingSn = shippingSn;
        this.createTime = createTime;
        this.shippingTime = shippingTime;
        this.payTime = payTime;
        this.receiveTime = receiveTime;
        this.orderStatus = orderStatus;
        this.orderPoint = orderPoint;
        this.invoiceTime = invoiceTime;
        this.modifiedTime = modifiedTime;
    }

    public OrderMaster() {
        super();
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Long getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(Long orderSn) {
        this.orderSn = orderSn;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getShippingUser() {
        return shippingUser;
    }

    public void setShippingUser(String shippingUser) {
        this.shippingUser = shippingUser == null ? null : shippingUser.trim();
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

    public Byte getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(Byte paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public BigDecimal getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(BigDecimal orderMoney) {
        this.orderMoney = orderMoney;
    }

    public BigDecimal getDistrictMoney() {
        return districtMoney;
    }

    public void setDistrictMoney(BigDecimal districtMoney) {
        this.districtMoney = districtMoney;
    }

    public BigDecimal getShippingMoney() {
        return shippingMoney;
    }

    public void setShippingMoney(BigDecimal shippingMoney) {
        this.shippingMoney = shippingMoney;
    }

    public BigDecimal getPaymentMoney() {
        return paymentMoney;
    }

    public void setPaymentMoney(BigDecimal paymentMoney) {
        this.paymentMoney = paymentMoney;
    }

    public String getShippingCompName() {
        return shippingCompName;
    }

    public void setShippingCompName(String shippingCompName) {
        this.shippingCompName = shippingCompName == null ? null : shippingCompName.trim();
    }

    public String getShippingSn() {
        return shippingSn;
    }

    public void setShippingSn(String shippingSn) {
        this.shippingSn = shippingSn == null ? null : shippingSn.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getShippingTime() {
        return shippingTime;
    }

    public void setShippingTime(Date shippingTime) {
        this.shippingTime = shippingTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public Byte getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Byte orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getOrderPoint() {
        return orderPoint;
    }

    public void setOrderPoint(Integer orderPoint) {
        this.orderPoint = orderPoint;
    }

    public String getInvoiceTime() {
        return invoiceTime;
    }

    public void setInvoiceTime(String invoiceTime) {
        this.invoiceTime = invoiceTime == null ? null : invoiceTime.trim();
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}