package com.kermi.market.userservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @Author : Kermi
 * @Date : 2019/12/17 10:44
 * @Version : 1.0
 */

@Configuration
@EnableRedisHttpSession
public class RedisSessionConfig {
}
