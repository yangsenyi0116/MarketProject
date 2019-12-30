package com.kermi.market.userservice.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author : Kermi
 * @Date : 2019/12/12 10:36
 * @Version : 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class  SessionAttributes implements Serializable {
    /*SessonID*/
    private String sessionID;
    /*Session中保存的用户UUID*/
    private String userUUID;
    /*Session保存的用户名*/
    private String userName;

}
