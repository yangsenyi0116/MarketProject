package com.kermi.market.userservice.enums;

import lombok.Data;

/**
 * @Author : Kermi
 * @Date : 2019/12/10 16:59
 * @Version : 1.0
 */
public enum UserStats {
    ENABLE(1),
    UNENABLE(0);

    private int data;

    private UserStats(int data){
        this.data=data;
    }

    public int getStats(){
        return this.data;
    }
}
