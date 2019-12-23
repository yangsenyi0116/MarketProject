package com.kermi.market.userservice.service;

import com.kermi.market.userservice.pojo.Customer;
import com.kermi.market.userservice.pojo.CustomerInfoFromWeb;
import com.kermi.market.userservice.pojo.SessionAttributes;

/**
 * @Author : Kermi
 * @Date : 2019/12/12 22:14
 * @Version : 1.0
 */
public interface UserInfService {

    /**
     * 根据SessionID先去Redis中获取Customer对象，如果不存在则去数据库中查询
     * @param sessionId
     * @return
     */
    Customer getCustomer(String sessionId);

    /**
     *
     * @param web CustomerInfoFromWeb对象，接收值
     * @return Customer对象
     */
    Customer setCustomerInfo(SessionAttributes attributes, CustomerInfoFromWeb web);
}
