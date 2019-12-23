package com.kermi.market.goodsservice.enums;

/**
 * @Author : Kermi
 * @Date : 2019/12/10 17:08
 * @Version : 1.0
 */
public enum IdentityCardType {
    IDCARD("身份证"),
    MINITARYOFFICER("军官证"),
    PASSPORT("护照");

    private String data;

    private IdentityCardType(String data) {
        this.data=data;
    }

    public String getType(){
        return this.data;
    }
}
