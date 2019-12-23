package com.kermi.market.userservice.service.impl;

import com.kermi.market.userservice.dao.CustomerInf;
import com.kermi.market.userservice.dao.CustomerLogin;
import com.kermi.market.userservice.enums.Gender;
import com.kermi.market.userservice.enums.IdentityCardType;
import com.kermi.market.userservice.enums.UserStats;
import com.kermi.market.userservice.mapper.CustomerInfMapper;
import com.kermi.market.userservice.mapper.CustomerLoginMapper;
import com.kermi.market.userservice.pojo.Customer;
import com.kermi.market.userservice.pojo.CustomerInfoFromWeb;
import com.kermi.market.userservice.pojo.SessionAttributes;
import com.kermi.market.userservice.service.UserInfService;
import com.kermi.market.userservice.untils.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author : Kermi
 * @Date : 2019/12/12 22:15
 * @Version : 1.0
 */
@Service
public class UserInfServiceImpl implements UserInfService {

    private Logger logger = LoggerFactory.getLogger(UserInfService.class);

    @Autowired
    private CustomerInfMapper infMapper;

    @Autowired
    private CustomerLoginMapper loginMapper;

    private String sessionprefix = "SESSION_";

    private static String prefixName = "CUSTOMER_NAME_";

    private static String prefixUUID = "CUSTOMER_UUID_";

    @Override
    public Customer getCustomer(String sessionId) {
        SessionAttributes attributes = null;
        try {
            //TODO 从Redis中取SessionAttributes对象
            attributes = (SessionAttributes) RedisUtil.get(sessionprefix + sessionId);
            logger.info("Redis读值:"+(sessionprefix+sessionId));
        }catch (Exception e){
            logger.error("UserService Redis error");
        }

        if (attributes != null) {
            String cusUUID = attributes.getUserUUID();
            String cusName = attributes.getUserName();
            Customer customer = null;
            try {
                customer = (Customer) RedisUtil.get(prefixUUID + cusUUID);
                logger.info("Redis取对象" + (prefixUUID + cusUUID));
            } catch (Exception e) {
                logger.error("UserService Redis error");
            }

            if (customer == null) {
                try {
                    customer = (Customer) RedisUtil.get(prefixName + cusName);
                    logger.info("Redis取对象" + (prefixName + cusName));
                }catch (Exception e){
                    logger.error("UserService Redis error");
                }

                if (customer == null) {
                    //TODO redis中查询为空，查找数据库
                    CustomerInf inf = infMapper.selectByUUID(cusUUID);
                    //获取Customer对象
                    CustomerLogin customerLogin = new CustomerLogin();customerLogin.setCustomerId(cusUUID);customerLogin.setLoginName(cusName);
                    customerLogin = loginMapper.querySelective(customerLogin);
                    Customer cus = customerLoginToCustomer(customerLogin);
                    if (inf == null) {
                        //数据库中为空
                        //TODO 写入Redis缓存中
                        try {
                            RedisUtil.save(prefixUUID + cus.getUUID(), cus);
                            logger.info("redis存入值:" + prefixUUID + cus.getUUID());
                            RedisUtil.save(prefixName + cus.getLoginUserName(), cus);
                            logger.info("redis存入值:" + prefixName + cus.getLoginUserName());
                        } catch (Exception e) {
                            logger.error("UserInfService Redis Error");
                        }
                        return cus;
                    }
                    //数据库中不为空
                    //TODO 向Customer对象中写入inf的信息
                    customer = writeInfIntoCustomer(cus, inf);
                    //写入Redis缓存
                    try {
                        RedisUtil.save(prefixUUID + customer.getUUID(), customer);
                        logger.info("redis存入值:" + prefixUUID + cus.getUUID());
                        RedisUtil.save(prefixName + customer.getLoginUserName(), customer);
                        logger.info("redis存入值:" + prefixName + cus.getLoginUserName());
                    } catch (Exception e) {
                        logger.error("UserInfService Redis Error");
                    }

                    return customer;
                }

                return customer;
            }
            // TODO customer从Redis中取到对象，直接返回对象
            return customer;
        }

        return null;
    }

    @Override
    public Customer setCustomerInfo(SessionAttributes attributes, CustomerInfoFromWeb web) {
        //TODO 从Redis中获取customer对象
        Customer rc = null;
        try {
            rc = (Customer) RedisUtil.get(prefixUUID + attributes.getUserUUID());
            logger.info("Redis取值"+prefixUUID+attributes.getUserUUID());
        } catch (Exception e) {
            logger.error("UserInfService Redis error");
        }
        if (rc == null) {
            try {
                rc = (Customer) RedisUtil.get(prefixName + attributes.getUserUUID());
                logger.info("Redis取值" + prefixName + attributes.getUserName());
            }catch (Exception e){
                logger.error("UserInfService Redis error");
            }

            if (rc == null) {
                //Redis中未找到相应数据，查找数据库
                CustomerLogin login = new CustomerLogin();login.setCustomerId(attributes.getUserUUID());login.setLoginName(attributes.getUserName());
                CustomerLogin customerLogin = loginMapper.querySelective(login);
                if (customerLogin == null) {
                    //数据库中找不到相应的Customer,一般不可达
                    return null;
                }
                //从数据库中取出的数据
                rc = customerLoginToCustomer(customerLogin);
            }

        }
        rc = writeInfIntoCustomer(rc, infoFromWebToInfo(web));
        CustomerInf writeIntoMysql = infoFromWebToInfo(web);
        writeIntoMysql.setCustomerId(rc.getUUID());
        int res = infMapper.insertSelective(writeIntoMysql);
        if (res == 0) {
            return null;
        }
        try {
            RedisUtil.save(prefixUUID + rc.getUUID(), rc);
            logger.info("Redis存入值:" + prefixUUID + rc.getUUID());
            RedisUtil.save(prefixName + rc.getLoginUserName(), rc);
            logger.info("Redis存入值:" + prefixName + rc.getLoginUserName());
        } catch (Exception e) {
            logger.error("UserInfService Redis Error");
        }
        return rc;
    }

    private Customer customerLoginToCustomer(CustomerLogin customerLogin) {
        Customer retCustomer = new Customer();
        retCustomer.setUUID(customerLogin.getCustomerId());
        retCustomer.setLoginUserName(customerLogin.getLoginName());
        retCustomer.setPassword(customerLogin.getPassword());
        retCustomer.setUser_stats(customerLogin.getUserStats()==1? UserStats.ENABLE:UserStats.UNENABLE);
        return retCustomer;
    }

    private CustomerInf infoFromWebToInfo(CustomerInfoFromWeb web) {
        CustomerInf retinf = new CustomerInf();
        if (web.getRealname() != null) {
            retinf.setCustomerName(web.getRealname());
        }
        if (web.getIdentityCardType() != 0) {
            retinf.setIdentityCardType((byte) web.getIdentityCardType());
        }
        if (web.getIdentityCardNum() != null) {
            retinf.setIdentityCardNo(web.getIdentityCardNum());
        }
        if (web.getPhoneNum() != 0) {
            retinf.setMobilePhone(web.getPhoneNum());
        }
        if (web.getEmail() != null) {
            retinf.setCustomerEmail(web.getEmail());
        }
        if (web.getGender() == 1) {
            retinf.setGender(Gender.MALE.getGender());
        } else if (web.getGender() == 2) {
            retinf.setGender(Gender.FAMALE.getGender());
        }
        return retinf;
    }

    private Customer writeInfIntoCustomer(Customer cus, CustomerInf inf) {
        logger.info(cus.toString());
        logger.info(inf.toString());
        cus.setRealname(inf.getCustomerName());
        if (inf.getIdentityCardType() == 1) {
            cus.setIdentityCardType(IdentityCardType.IDCARD);
        } else {
            if (inf.getIdentityCardType() == 2) {
                cus.setIdentityCardType(IdentityCardType.MINITARYOFFICER);
            } else {
                cus.setIdentityCardType(IdentityCardType.PASSPORT);
            }
        }
        cus.setIdentityCardNum(inf.getIdentityCardNo());
        if (inf.getMobilePhone()!=null){
            cus.setPhontNum(inf.getMobilePhone());
        }
        if (inf.getCustomerEmail()!=null){
            cus.setEmail(inf.getCustomerEmail());
        }
        if (inf.getGender() == "男") {
            cus.setGender(Gender.MALE);
        } else {
            cus.setGender(Gender.FAMALE);
        }
        if (inf.getUserPoint() != null) {
            cus.setUser_point(inf.getUserPoint());
        }
        if (inf.getIdentityCardNo() == null) {
            cus.setBirthday(null);
        } else {
            cus.setBirthday(identityCartNoToBirth(inf.getIdentityCardNo()));
        }
        return cus;
    }

    private Date identityCartNoToBirth(String cardNo) {
        Date date = null;
        DateFormat format = new SimpleDateFormat("yyyyMMdd");
        try {
            date = format.parse(cardNo.substring(6, 14));
        } catch (ParseException e) {
            logger.error("转换类型失败" + format.getClass());
        }
        return date;
    }
}
