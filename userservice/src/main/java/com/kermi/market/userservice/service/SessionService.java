package com.kermi.market.userservice.service;

import com.kermi.market.userservice.pojo.SessionAttributes;

/**
 * @Author : Kermi
 * @Date : 2019/12/12 10:40
 * @Version : 1.0
 */
public interface SessionService {

    /**
     * 将Session中存的值写到缓存中
     * @param attributes SessionAttributes自定义类
     */
    void writeSessionAttributesToRedis(SessionAttributes attributes);

    /**
     * 从Redis中获取Session值
     * @param SessionID
     * @return
     */
    SessionAttributes getSessionAttributesFromRedis(String SessionID);
}
