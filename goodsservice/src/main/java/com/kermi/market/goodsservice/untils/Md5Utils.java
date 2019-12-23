package com.kermi.market.goodsservice.untils;

import org.apache.tomcat.util.security.MD5Encoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author : Kermi
 * @Date : 2019/12/10 20:40
 * @Version : 1.0
 */
public class Md5Utils {
    protected static Logger logger = LoggerFactory.getLogger(Md5Utils.class);

    public static String getMd5(String data){

        String resultString = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            resultString = MD5Encoder.encode(md.digest(data.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            logger.error("md5失败");
            e.printStackTrace();
        }

        return resultString;
    }
}
