package com.kermi.market.userservice.pojo;

import com.kermi.market.userservice.enums.Gender;
import com.kermi.market.userservice.enums.IdentityCardType;
import com.kermi.market.userservice.enums.UserStats;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Author : Kermi
 * @Date : 2019/12/10 16:56
 * @Version : 1.0
 */
@Data
public class Customer implements Serializable {
    /*用户UUID*/
    private String UUID;

    /*用户登录名*/
    private String loginUserName;

    /*用户密码*/
    private String password;

    /*用户状态*/
    private UserStats user_stats;

    /*用户真实姓名*/
    private String realname;

    /*用户证件类型*/
    private IdentityCardType identityCardType;

    /*证件号码*/
    private String identityCardNum;

    /*手机号*/
    private int phontNum;

    /*邮箱*/
    private String email;

    /*性别*/
    private Gender gender;

    /*用户积分*/
    private int user_point;

    /*用户生日*/
    private Date birthday;

    /*地址*/
    private List<CustomerAddr> customerAddrs;
}
