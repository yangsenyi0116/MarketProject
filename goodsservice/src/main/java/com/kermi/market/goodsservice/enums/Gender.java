package com.kermi.market.goodsservice.enums;

/**
 * @Author : Kermi
 * @Date : 2019/12/10 19:56
 * @Version : 1.0
 */
public enum  Gender {
    MALE("男"),
    FAMALE("女");

    private String gender;

    private Gender(String gender){
        this.gender = gender;
    }

    public String getGender(){
        return gender;
    }
}
