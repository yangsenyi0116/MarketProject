package com.kermi.market.userservice.service.impl;

import com.kermi.market.userservice.config.AppConfig;
import com.kermi.market.userservice.dao.CustomerLogin;
import com.kermi.market.userservice.enums.UserStats;
import com.kermi.market.userservice.mapper.CustomerLoginMapper;
import com.kermi.market.userservice.pojo.Customer;
import com.kermi.market.userservice.service.UserService;
import com.kermi.market.userservice.untils.DateUtils;
import com.kermi.market.userservice.untils.RedisUtil;
import com.kermi.market.userservice.untils.SerializeUtil;
import com.kermi.market.userservice.untils.UUIDUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Date;

/**
 * @Author : Kermi
 * @Date : 2019/12/10 20:39
 * @Version : 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private CustomerLoginMapper customerLoginMapper;

    @Autowired
    private ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    private static String prefixName = "CUSTOMER_NAME_";

    private static String prefixUUID = "CUSTOMER_UUID_";

    private static String redisprefixNAME = "CUSTOMERLOGIN_NAME_";

    private static String redisprefixUUID = "CUSTOMERLOGIN_UUID_";

    /**
     * 检查用户名是否存在与数据库
     * @param login_name
     * @return true of false
     */
    @Override
    public boolean checkforExist(String login_name) {
        CustomerLogin customerLogin = null;
        Customer customer = null;
        //先去查找redis缓存，如果缓存中存在则直接返回
        try {
            logger.info("读取Redis值:"+prefixName+login_name);
            customer = (Customer) RedisUtil.get(prefixName + login_name);
        } catch (Exception e) {
            logger.error("redispool get exception");
        }

        if (customer == null) {
            try {
                customerLogin = (CustomerLogin) RedisUtil.get(redisprefixNAME + login_name);
            }catch (Exception e){
                logger.error("redispool get exception");
                customerLogin = null;
            }

            if (customerLogin == null) {
                //缓存中不存在，去查找mysql数据库
                logger.info("查找数据库");
                CustomerLogin cacheCustomer = new CustomerLogin();
                cacheCustomer.setLoginName(login_name);
                customerLogin = customerLoginMapper.querySelective(cacheCustomer);
                if (customerLogin == null) {
                    return false;
                } else {
                    return true;
                }
            }

            return true;
        }

        return true;


    }


    /**
     * 向数据库中写入新数据
     * @param login_name 用户名
     * @param md5password md5加密后的密码
     * @return true or false
     * */
    @Override
    public boolean registeNewCustomer(String login_name, String md5password) {
        CustomerLogin customerLogin = new CustomerLogin();
        customerLogin.setCustomerId(UUIDUtils.getUUID());
        customerLogin.setLoginName(login_name);
        customerLogin.setPassword(md5password);
        customerLogin.setUserStats((byte) UserStats.ENABLE.getStats());
        customerLogin.setModifiedTime(new Date());
        //先写入mysql数据库
        int res = customerLoginMapper.insertSelective(customerLogin);
        if (res == 0) {
            //插入失败
            return false;
        }
        //插入成功,写入Redis缓存

        try {
            RedisUtil.save((redisprefixUUID + customerLogin.getCustomerId()), customerLogin);
            logger.info("redis保存值:" + redisprefixUUID + customerLogin.getCustomerId());
            RedisUtil.save((redisprefixNAME + customerLogin.getLoginName()), customerLogin);
            logger.info("redis保存值:" + redisprefixUUID + customerLogin.getLoginName());
            //构建Customer对象存入Redis缓存中
            Customer customer = customerLoginToCustomer(customerLogin);
            RedisUtil.save(prefixUUID + customer.getUUID(), customer);
            logger.info("redis保存值:" + prefixUUID + customer.getUUID());
            RedisUtil.save(prefixName + customer.getLoginUserName(), customer);
            logger.info("redis保存值:" + prefixName + customer.getLoginUserName());
        } catch (Exception e) {
            logger.error("redis error");
        }
        return true;
    }

    /**
     * 从Redis中获取用户数据，如果没有读到，则读取数据库
     * 读取到值后比对密码
     * @param loginCustomer 登录的Customer对象
     * @return true or false
     */
    @Override
    public Customer loginUser(Customer loginCustomer) {
        CustomerLogin customerLogin = null;
        Customer customer = null;
        try {
            customer = (Customer) RedisUtil.get(prefixName + loginCustomer.getLoginUserName());
        }catch (Exception e){
            logger.error("loginUserFunction redis error");
        }

        if (customer!=null){
            //Redis取Customer对象成功
            if (loginCustomer.getPassword().equals(customer.getPassword())) {
                //密码正确
                return customer;
            }
            //密码错误
            return null;
        }

        //Redis取Customer对象为空
        try {
            customerLogin = (CustomerLogin) RedisUtil.get(redisprefixNAME + loginCustomer.getLoginUserName());
        }catch (Exception e){
            logger.error("redis error");
        }

        if (customerLogin != null) {
            //Redis中取到值
            logger.info("redis中取到值"+redisprefixNAME+loginCustomer.getLoginUserName());
            if (customerLogin.getPassword().equals(loginCustomer.getPassword())) {
                //密码正确
                //将值存到返回对象Customer中返回
                return customerLoginToCustomer(customerLogin);
            }
            //密码错误 直接返回null值
            return null;
        }
        //从Redis中没有取到值，查找Mysql数据库
        customerLogin = new CustomerLogin();
        customerLogin.setLoginName(loginCustomer.getLoginUserName());
        customerLogin.setPassword(loginCustomer.getPassword());
        CustomerLogin cusFromMysql = customerLoginMapper.querySelective(customerLogin);
        if (cusFromMysql!=null){
            //从数据库中取到值
            try {
                RedisUtil.save(prefixName + cusFromMysql.getLoginName(), cusFromMysql);
                logger.info("redis存入值:" + prefixName + cusFromMysql.getLoginName());
                RedisUtil.save(prefixUUID + cusFromMysql.getCustomerId(), cusFromMysql);
                logger.info("redis存入值:" + prefixUUID + cusFromMysql.getCustomerId());
                RedisUtil.save(redisprefixNAME + cusFromMysql.getLoginName(), cusFromMysql);
                logger.info("redis存入值:" + redisprefixNAME + cusFromMysql.getLoginName());
                RedisUtil.save(redisprefixUUID + cusFromMysql.getCustomerId(), cusFromMysql);
                logger.info("redis存入值:" + redisprefixNAME + cusFromMysql.getCustomerId());
            } catch (Exception e) {
                logger.error("UserService Redis error");
            }

            if (cusFromMysql.getPassword().equals(loginCustomer.getPassword())) {
                //密码正确
                //将值存到返回对象Customer中返回
                return customerLoginToCustomer(cusFromMysql);
            }
            //密码错误返回null值
            return null;
        }
        //从数据库中没取到值
        return null;
    }

    /**
     * 将CustomerLogin对象转成Customer对象
     * @param customerLogin 传入的customerLogin对象
     * @return Customer
     */
    private Customer customerLoginToCustomer(CustomerLogin customerLogin) {
        Customer retCustomer = new Customer();
        retCustomer.setUUID(customerLogin.getCustomerId());
        retCustomer.setLoginUserName(customerLogin.getLoginName());
        retCustomer.setPassword(customerLogin.getPassword());
        retCustomer.setUser_stats(customerLogin.getUserStats()==1? UserStats.ENABLE:UserStats.UNENABLE);
        return retCustomer;
    }
}
