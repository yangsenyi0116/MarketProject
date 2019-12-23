package com.kermi.market.userservice.untils;

/**
 * @Author : Kermi
 * @Date : 2019/12/11 22:56
 * @Version : 1.0
 */

import com.kermi.market.userservice.config.RedisCacheConfiguration;
import lombok.Data;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * s
 *
 * @描述: Redis缓存工具类.
 * @版本: V1.0
 */
@Data
public class RedisUtil {

    private static Logger logger = Logger.getLogger(RedisUtil.class);

    /**
     * 默认缓存时间
     */
    private static final int DEFAULT_CACHE_SECONDS = 60 * 60 * 5;// 单位秒 设置成一个钟

    private static JedisPool jedisPool;

    /**
     * 连接池
     **/
    static {
        ApplicationContext context = new AnnotationConfigApplicationContext(RedisCacheConfiguration.class);
        jedisPool = (JedisPool) context.getBean("jedispool");
    }

    /**
     * 释放redis资源
     *
     * @param jedis
     */
    private static void releaseResource(Jedis jedis) {
        if (jedis != null) {
            jedisPool.returnResource(jedis);
        }
    }

    /**
     * 删除Redis中的所有key
     *
     * @throws Exception
     */
    public static void flushAll() {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.flushAll();
        } catch (Exception e) {
            logger.error("Cache清空失败：" + e);
        } finally {
            releaseResource(jedis);
        }
    }

    /**
     * 保存一个对象到Redis中(缓存过期时间:使用此工具类中的默认时间) . <br/>
     *
     * @param key    键 . <br/>
     * @param object 缓存对象 . <br/>
     * @return true or false . <br/>
     * @throws Exception
     */
    public static Boolean save(Object key, Object object) {
        return save(key, object, DEFAULT_CACHE_SECONDS);
    }

    /**
     * 保存一个对象到redis中并指定过期时间
     *
     * @param key     键 . <br/>
     * @param object  缓存对象 . <br/>
     * @param seconds 过期时间（单位为秒）.<br/>
     * @return true or false .
     */
    public static Boolean save(Object key, Object object, int seconds) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.   set(SerializeUtil.serialize(key), SerializeUtil.serialize(object));
            jedis.expire(SerializeUtil.serialize(key), seconds);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Cache保存失败：" + e);
            return false;
        } finally {
            releaseResource(jedis);
        }
    }

    /**
     * 根据缓存键获取Redis缓存中的值.<br/>
     *
     * @param key 键.<br/>
     * @return Object .<br/>
     * @throws Exception
     */
    public static Object get(Object key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            byte[] obj = jedis.get(SerializeUtil.serialize(key));
            return obj == null ? null : SerializeUtil.unserialize(obj);
        } catch (Exception e) {
            logger.error("Cache获取失败：" + e);
            return null;
        } finally {
            releaseResource(jedis);
        }
    }

    /**
     * 根据缓存键清除Redis缓存中的值.<br/>
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static Boolean del(Object key) {
        Jedis jedis = null;
        try {
            // System.out.println(key);
            jedis = jedisPool.getResource();
            jedis.del(SerializeUtil.serialize(key));
            return true;
        } catch (Exception e) {
            logger.error("Cache删除失败：" + e);
            return false;
        } finally {
            releaseResource(jedis);
        }
    }

    /**
     * 根据缓存键清除Redis缓存中的值.<br/>
     *
     * @param keys
     * @return
     * @throws Exception
     */
    public static Boolean del(Object... keys) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.del(SerializeUtil.serialize(keys));
            return true;
        } catch (Exception e) {
            logger.error("Cache删除失败：" + e);
            return false;
        } finally {
            releaseResource(jedis);
        }
    }

    /**
     * @param key
     * @param seconds 超时时间（单位为秒）
     * @return
     */
    public static Boolean expire(Object key, int seconds) {

        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.expire(SerializeUtil.serialize(key), seconds);
            return true;
        } catch (Exception e) {
            logger.error("Cache设置超时时间失败：" + e);
            return false;
        } finally {
            releaseResource(jedis);
        }
    }

    /**
     * 添加一个内容到指定key的hash中
     *
     * @param key
     * @param field
     * @param value
     * @return
     */
    public static Boolean addHash(String key, Object field, Object value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.hset(SerializeUtil.serialize(key), SerializeUtil.serialize(field), SerializeUtil.serialize(value));
            return true;
        } catch (Exception e) {
            logger.error("Cache保存失败：" + e);
            return false;
        } finally {
            releaseResource(jedis);
        }
    }

    /**
     * 从指定hash中拿一个对象
     *
     * @param key
     * @param field
     * @return
     */
    public static Object getHash(Object key, Object field) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            byte[] obj = jedis.hget(SerializeUtil.serialize(key), SerializeUtil.serialize(field));
            return SerializeUtil.unserialize(obj);
        } catch (Exception e) {
            logger.error("Cache读取失败：" + e);
            return null;
        } finally {
            releaseResource(jedis);
        }
    }

    /**
     * 从hash中删除指定filed的值
     *
     * @param key
     * @param field
     * @return
     */
    public static Boolean delHash(Object key, Object field) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            long result = jedis.hdel(SerializeUtil.serialize(key), SerializeUtil.serialize(field));
            return result == 1 ? true : false;
        } catch (Exception e) {
            logger.error("Cache删除失败：" + e);
            return null;
        } finally {
            releaseResource(jedis);
        }
    }

    /**
     * 拿到缓存中所有符合pattern的key
     *
     * @param pattern
     * @return
     */
    public static Set<byte[]> keys(String pattern) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            Set<byte[]> allKey = jedis.keys(("*" + pattern + "*").getBytes());
            return allKey;
        } catch (Exception e) {
            logger.error("Cache获取失败：" + e);
            return new HashSet<byte[]>();
        } finally {
            releaseResource(jedis);
        }
    }

    /**
     * 获得hash中的所有key value
     *
     * @param key
     * @return
     */
    public static Map<byte[], byte[]> getAllHash(Object key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            Map<byte[], byte[]> map = jedis.hgetAll(SerializeUtil.serialize(key));
            return map;
        } catch (Exception e) {
            logger.error("Cache获取失败：" + e);
            return null;
        } finally {
            releaseResource(jedis);
        }
    }

    /**
     * 判断一个key是否存在
     *
     * @param key
     * @return
     */
    public static Boolean exists(Object key) {
        Jedis jedis = null;
        Boolean result = false;
        try {
            jedis = jedisPool.getResource();
            result = jedis.exists(SerializeUtil.serialize(key));
            return result;
        } catch (Exception e) {
            logger.error("Cache获取失败：" + e);
            return false;
        } finally {
            releaseResource(jedis);
        }
    }
}
