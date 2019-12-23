package com.kermi.market.goodsservice.untils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author : Kermi
 * @Date : 2019/12/11 10:33
 * @Version : 1.0
 */
public class DateUtils {
    public static String dateFormat(Date date){
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }
}
