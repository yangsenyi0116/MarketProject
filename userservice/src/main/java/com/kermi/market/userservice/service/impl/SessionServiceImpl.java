package com.kermi.market.userservice.service.impl;

import com.kermi.market.userservice.pojo.SessionAttributes;
import com.kermi.market.userservice.service.SessionService;
import com.kermi.market.userservice.untils.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Author : Kermi
 * @Date : 2019/12/12 10:41
 * @Version : 1.0
 */
@Service
public class SessionServiceImpl implements SessionService {

    private Logger logger = LoggerFactory.getLogger(SessionService.class);

    private String sessionRedisPrefix = "SESSION_";

    /**
     * 将Session写入缓存中
     * @param attributes SessionAttributes自定义类
     */
    @Override
    public void writeSessionAttributesToRedis(SessionAttributes attributes) {
        try {
            RedisUtil.save(sessionRedisPrefix + attributes.getSessionID(), attributes);
            logger.info("redis存入值:" + sessionRedisPrefix + attributes.getSessionID());
        } catch (Exception e) {
            logger.error("SessionService redis error");
        }
    }

    /**
     * 从Redis中读取Session缓存
     * @param sessionID sessionID
     * @return sessionAttributes对象
     */
    @Override
    public SessionAttributes getSessionAttributesFromRedis(String sessionID) {
        SessionAttributes session;
        try {
            session = (SessionAttributes) RedisUtil.get(sessionRedisPrefix + sessionID);
            logger.info("redis取出值:"+sessionRedisPrefix+sessionID);
        }catch (Exception e){
            logger.error("SessionService redis error");
            session = null;
        }
        return session;
    }
}
