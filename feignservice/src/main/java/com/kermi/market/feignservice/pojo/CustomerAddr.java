package com.kermi.market.feignservice.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author : Kermi
 * @Date : 2019/12/15 21:31
 * @Version : 1.0
 */
@Data
@AllArgsConstructor
public class CustomerAddr implements Serializable {
    /*邮编*/
    private int zip;
    /*省份*/
    private String province;
    /*城市*/
    private String city;
    /*区*/
    private String district;
    /*详细地址*/
    private String address;
    /*是否为默认地址*/
    private boolean isDefault;

    public CustomerAddr(){super();}
}
