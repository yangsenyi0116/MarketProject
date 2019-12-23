package com.kermi.market.userservice.service;

import com.kermi.market.userservice.pojo.CustomerAddr;
import com.kermi.market.userservice.pojo.SessionAttributes;

import java.util.List;

/**
 * @Author : Kermi
 * @Date : 2019/12/15 22:11
 * @Version : 1.0
 */
public interface UserAddrService {
    /**
     * 获取当前用户的默认地址
     * @param attributes sessionAttribute对象
     * @return CustomerAddr pojo对象
     */
    CustomerAddr getDefaultAddr(SessionAttributes attributes);

    /**
     * 获取所有已经存入的地址
     * @param attributes sessionAttribute对象
     * @return List<CustomerAddr>数组
     */
    List<CustomerAddr> getAllAddr(SessionAttributes attributes);

    /**
     * 写入收货地址
     * @param attributes sessionAttribute对象
     * @param web CustomerAddr对象
     * @return true of false
     */
    boolean saveAddr(SessionAttributes attributes, CustomerAddr web);
}
