package com.kermi.market.feignservice.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author : Kermi
 * @Date : 2019/12/13 22:44
 * @Version : 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerInfoFromWeb {
    /*用户真实姓名*/
    private String realname;

    /*用户证件类型*/
    private int identityCardType;

    /*证件号码*/
    private String identityCardNum;

    /*手机号*/
    private int phoneNum;

    /*邮箱*/
    private String email;

    /*性别*/
    private int gender;
}
