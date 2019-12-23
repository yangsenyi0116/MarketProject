package com.kermi.market.userservice.untils;

/**
 * @Author : Kermi
 * @Date : 2019/12/11 9:32
 * @Version : 1.0
 */
public enum ResponseCode {

    SUCCESS(200),
    BADREQUEST(400),
    NOTFOUNT(404),
    SERVICE_ERROR(500);

    private int code;

    private ResponseCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
    }
