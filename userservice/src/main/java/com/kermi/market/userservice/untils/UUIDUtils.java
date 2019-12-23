package com.kermi.market.userservice.untils;

import java.util.UUID;

/**
 * @Author : Kermi
 * @Date : 2019/12/10 15:02
 * @Version : 1.0
 */
public class UUIDUtils {
    public static String getUUID(){
        return UUID.randomUUID().toString();
    }
}
