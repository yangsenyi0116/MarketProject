package com.kermi.market.userservice.untils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author : Kermi
 * @Date : 2019/12/11 9:14
 * @Version : 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseUtils {
    /*状态码*/
    private ResponseCode code;
    /*返回的数据*/
    private Object data;
    /*错误信息*/
    private String error;
}
