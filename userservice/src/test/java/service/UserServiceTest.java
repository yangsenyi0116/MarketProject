package service;

import com.kermi.market.userservice.UserSerivceApplication;
import com.kermi.market.userservice.config.AppConfig;
import com.kermi.market.userservice.config.RedisCacheConfiguration;
import com.kermi.market.userservice.dao.CustomerLogin;
import com.kermi.market.userservice.enums.UserStats;
import com.kermi.market.userservice.mapper.CustomerLoginMapper;
import com.kermi.market.userservice.pojo.Customer;
import com.kermi.market.userservice.service.UserService;
import com.kermi.market.userservice.service.impl.UserServiceImpl;
import com.kermi.market.userservice.untils.RedisUtil;
import com.kermi.market.userservice.untils.SerializeUtil;
import com.kermi.market.userservice.untils.UUIDUtils;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author : Kermi
 * @Date : 2019/12/10 21:43
 * @Version : 1.0
 */
@SpringBootTest
public class UserServiceTest {
    @Test
    public void test(){
        System.out.println((byte) UserStats.ENABLE.getStats());
    }

    @Test
    public void test2(){
        System.out.println(dateFormat(new Date()));
    }


    @Test
    public void test3(){
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CustomerLogin customerLogin = (CustomerLogin) context.getBean("customerLogin");
        customerLogin.setCustomerId(UUIDUtils.getUUID());
        customerLogin.setLoginName("aaa");
        customerLogin.setPassword("123123213213123213");
        customerLogin.setUserStats((byte) UserStats.ENABLE.getStats());
        customerLogin.setModifiedTime(new Date());
        System.out.println(customerLogin);
    }


    @Test
    public void test4() throws ClassNotFoundException {
        ApplicationContext context1 = new AnnotationConfigApplicationContext(RedisCacheConfiguration.class);
        JedisPool jedisPool = (JedisPool) context1.getBean("jedispool");
        Jedis jedis = jedisPool.getResource();
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CustomerLogin customerLogin = (CustomerLogin) context.getBean("customerLogin");
        customerLogin.setCustomerId(UUIDUtils.getUUID());
        customerLogin.setLoginName("aaa");
        customerLogin.setPassword("123123213213123213");
        customerLogin.setUserStats((byte) UserStats.ENABLE.getStats());
        customerLogin.setModifiedTime(new Date());
        jedis.hset("CUSTOMERLOGIN_AAA","UUID",customerLogin.getCustomerId());
        jedis.hset("CUSTOMERLOGIN_AAA", "LOGINNAME", customerLogin.getLoginName());
        jedis.hset("CUSTOMERLOGIN_AAA", "PASSWORD", customerLogin.getPassword());
        jedis.hset("CUSTOMERLOGIN_AAA","USERSTATS",String.valueOf(customerLogin.getUserStats()));
        jedis.hset("CUSTOMERLOGIN_AAA", "MODIFIEDTIME", String.valueOf(customerLogin.getModifiedTime()));

    }


    @Test
    public void test5(){
        ApplicationContext context1 = new AnnotationConfigApplicationContext(RedisCacheConfiguration.class);
        JedisPool jedisPool = (JedisPool) context1.getBean("jedispool");
        Jedis jedis = jedisPool.getResource();
        System.out.println(jedis.hgetAll("CUSTOMERLOGIN_AAA"));
    }


    @Test
    public void test6(){
        ApplicationContext context1 = new AnnotationConfigApplicationContext(RedisCacheConfiguration.class);
        JedisPool jedisPool = (JedisPool) context1.getBean("jedispool");
        Jedis jedis = jedisPool.getResource();
        byte[] customer = jedis.get(("CUSTOMERLOGIN_NAME_" + "aaa").getBytes());
        System.out.println(customer.length);
        System.out.println(customer==null);
        System.out.println((CustomerLogin) SerializeUtil.unserialize(customer));
    }

    @Test
    public void test7(){
        ApplicationContext context1 = new AnnotationConfigApplicationContext(RedisCacheConfiguration.class);
        JedisPool jedisPool = (JedisPool) context1.getBean("jedispool");
        Jedis jedis = jedisPool.getResource();
        CustomerLogin customerLogin = new CustomerLogin();
        customerLogin.setLoginName("aaa");
        customerLogin.setPassword("1231123123");
        jedis.set(("CUSTOMERLOGIN_NAME_" + "aaa").getBytes(), SerializeUtil.serialize(customerLogin));
    }
    public String dateFormat(Date date){
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }

    @Test
    public void test8(){
        CustomerLogin login = null;
        try {
            login = (CustomerLogin) RedisUtil.get("CUSTOMERLOGIN_NAME_aac");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(login);
    }

    @Test
    public void test9() {
        CustomerLogin customerLogin = new CustomerLogin();
        customerLogin.setLoginName("aaa");
        customerLogin.setPassword("123456");
        System.out.println(RedisUtil.save("CUSTOMER_NAME_aaa", customerLogin));
    }

    @Test
    public void test10() {
        CustomerLogin customerLogin = new CustomerLogin();
        customerLogin.setCustomerId(UUIDUtils.getUUID());
        customerLogin.setLoginName("aaa");
        customerLogin.setPassword("123456");
        customerLogin.setUserStats((byte) UserStats.ENABLE.getStats());
        customerLogin.setModifiedTime(new Date());
        System.out.println(RedisUtil.save("CUSTOMER_NAME_aaa", customerLogin));
    }
}
