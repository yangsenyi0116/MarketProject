package com.kermi.market.goodsservice.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Author : Kermi
 * @Date : 2019/12/11 9:49
 * @Version : 1.0
 */
@Configuration
public class RedisCacheConfiguration {
    Logger logger = LoggerFactory.getLogger(RedisCacheConfiguration.class);

    @Value("${spring.redis.host:#{'localhost'}}")
    private String host;

    @Value("${spring.redis.port:#{6379}}")
    private int port;

    @Value("${spring.redis.timeout:#{0}}")
    private int timeout;

    @Value("${spring.redis.pool.max-idle:#{0}}")
    private int maxIdle;

    @Value("${spring.redis.pool.max-wait:#{-1}}")
    private long maxWaitMillis;

    private String password = null;

    @Bean(name = "jedispool")
    public JedisPool redisPoolFactory() {
        logger.info("redisPool注入成功");
        logger.info("redis地址" + host + ":" + port);
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);

        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout, password);
        return jedisPool;
    }
}
