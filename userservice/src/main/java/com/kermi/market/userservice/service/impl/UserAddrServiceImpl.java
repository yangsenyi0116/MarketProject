package com.kermi.market.userservice.service.impl;

import com.kermi.market.userservice.dao.CustomerInf;
import com.kermi.market.userservice.dao.CustomerLogin;
import com.kermi.market.userservice.enums.Gender;
import com.kermi.market.userservice.enums.IdentityCardType;
import com.kermi.market.userservice.enums.UserStats;
import com.kermi.market.userservice.mapper.CustomerAddrMapper;
import com.kermi.market.userservice.mapper.CustomerInfMapper;
import com.kermi.market.userservice.mapper.CustomerLoginMapper;
import com.kermi.market.userservice.pojo.Customer;
import com.kermi.market.userservice.pojo.CustomerAddr;
import com.kermi.market.userservice.pojo.SessionAttributes;
import com.kermi.market.userservice.service.UserAddrService;
import com.kermi.market.userservice.untils.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author : Kermi
 * @Date : 2019/12/15 22:11
 * @Version : 1.0
 */
@Service
public class UserAddrServiceImpl implements UserAddrService {

    private Logger logger = LoggerFactory.getLogger(UserAddrService.class);

    @Autowired
    private CustomerAddrMapper addrMapper;

    @Autowired
    private CustomerLoginMapper loginMapper;

    @Autowired
    private CustomerInfMapper infMapper;

    private static String prefixName = "CUSTOMER_NAME_";

    private static String prefixUUID = "CUSTOMER_UUID_";

    @Override
    public CustomerAddr getDefaultAddr(SessionAttributes attributes) {
        com.kermi.market.userservice.dao.CustomerAddr addr = null;
        CustomerAddr customerAddr = null;
        Customer customer = null;
        try {
            logger.info("Redis查找值:" + prefixUUID + attributes.getUserUUID());
            customer = (Customer) RedisUtil.get(prefixUUID + attributes.getUserUUID());
        } catch (Exception e) {
            logger.error("UserAddrService Redis Error");
        }

        if (customer == null) {
            try {
                logger.info("Redis查找值:" + prefixName + attributes.getUserName());
                customer = (Customer) RedisUtil.get(prefixName + attributes.getUserName());
            }
            catch (Exception e){
                logger.error("UserAddrService Redis Error");
            }

            if (customer == null) {
                //Redis中没找到Customer对象
                //数据库中查找对象并存到Redis缓存中
                addr = new com.kermi.market.userservice.dao.CustomerAddr();addr.setCustomerId(attributes.getUserUUID());
                List<com.kermi.market.userservice.dao.CustomerAddr> list = addrMapper.querySelective(addr);
                customer = getCustomer(attributes);
                if (customer == null) {
                    return null;
                }
                List<CustomerAddr> customerAddrs = customer.getCustomerAddrs();
                for (com.kermi.market.userservice.dao.CustomerAddr addrs: list){
                    customerAddrs.add(daoAddrTopojoAddr(addrs));
                }
                customer.setCustomerAddrs(customerAddrs);
                saveCustomerToRedis(customer);

                for (CustomerAddr addrlist : customerAddrs) {
                    if (addrlist.isDefault()){
                        return addrlist;
                    }
                }
            }
        }

        List<CustomerAddr> customerAddrs = customer.getCustomerAddrs();
        for (CustomerAddr addrlist : customerAddrs) {
            if (addrlist.isDefault()) {
                return addrlist;
            }
        }
        return null;
    }

    @Override
    public List<CustomerAddr> getAllAddr(SessionAttributes attributes) {
        com.kermi.market.userservice.dao.CustomerAddr daoaddr = null;
        CustomerAddr pojoaddr = null;
        Customer customer = null;
        try {
            customer = (Customer) RedisUtil.get(prefixUUID + attributes.getUserUUID());
        } catch (Exception e) {
            logger.error("UserAddrService Redis Error");
        }

        if (customer == null) {
            try {
                customer = (Customer) RedisUtil.get(prefixName + attributes.getUserName());
            } catch (Exception e) {
                logger.error("UserAddrService Redis Error");
            }

            if (customer == null) {
                //TODO 查找数据库
                customer = getCustomer(attributes);
                daoaddr = new com.kermi.market.userservice.dao.CustomerAddr();daoaddr.setCustomerId(customer.getUUID());
                List<com.kermi.market.userservice.dao.CustomerAddr> daoaddrlist = addrMapper.querySelective(daoaddr);
                List<CustomerAddr> pojoaddrlist = new ArrayList<>();
                for (com.kermi.market.userservice.dao.CustomerAddr addr : daoaddrlist) {
                    pojoaddrlist.add(daoAddrTopojoAddr(addr));
                }

                customer.setCustomerAddrs(pojoaddrlist);
                //写入Redis缓存
                saveCustomerToRedis(customer);

                return  pojoaddrlist;
            }
        }
        //不为空
        return customer.getCustomerAddrs();
    }

    @Override
    public boolean saveAddr(SessionAttributes attributes, CustomerAddr web) {
        com.kermi.market.userservice.dao.CustomerAddr daoaddr = null;
        Customer customer = null;
        daoaddr = pojoAddrToDaoAddr(attributes.getUserUUID(), web);
        int result = addrMapper.insertSelective(daoaddr);
        if (result == 1) {
            try {
                customer = (Customer) RedisUtil.get(prefixUUID + attributes.getUserUUID());
                logger.info("Redis读取值:" + prefixUUID + attributes.getUserUUID());
            }catch (Exception e){
                logger.error("UserAddrService Redis Error");
            }

            if (customer == null) {
                try {
                    customer = (Customer) RedisUtil.get(prefixName + attributes.getUserName());
                    logger.info("Redis读取值:" + prefixUUID + attributes.getUserName());
                }catch (Exception e){
                    logger.error("UserAddrService Redis Error");
                }

                if (customer == null) {
                    //Redis缓存中没值，从数据库中取值
                    customer = getCustomer(attributes);
                    List<CustomerAddr> addrlist = new ArrayList<>();
                    addrlist.add(web);
                    customer.setCustomerAddrs(addrlist);

                    //存到Redis数据库
                    saveCustomerToRedis(customer);
                }
            }


            //Redis中取到Customer对象，向List中写入新地址，再存入Redis中
            List<CustomerAddr> addrlist = customer.getCustomerAddrs();
            if (addrlist == null) {
                addrlist = new ArrayList<>();
            }
            addrlist.add(web);
            try {
                customer.setCustomerAddrs(addrlist);
            }catch (NullPointerException e){
                e.printStackTrace();
            }
            saveCustomerToRedis(customer);
            return true;
        }
        return false;
    }

    private Customer getCustomer(SessionAttributes attributes){
        Customer retcus = null;
        CustomerLogin customerLogin = new CustomerLogin();customerLogin.setCustomerId(attributes.getUserUUID());customerLogin.setLoginName(attributes.getUserName());
        customerLogin = loginMapper.querySelective(customerLogin);
        if (customerLogin == null) {
            return null;
        }
        retcus = customerLoginToCustomer(customerLogin);
        CustomerInf customerInf = null;
        customerInf = infMapper.selectByUUID(retcus.getUUID());
        if (customerInf == null) {
            return null;
        }
        return writeInfIntoCustomer(retcus, customerInf);
    }

    private Customer customerLoginToCustomer(CustomerLogin customerLogin) {
        Customer retCustomer = new Customer();
        retCustomer.setUUID(customerLogin.getCustomerId());
        retCustomer.setLoginUserName(customerLogin.getLoginName());
        retCustomer.setPassword(customerLogin.getPassword());
        retCustomer.setUser_stats(customerLogin.getUserStats()==1? UserStats.ENABLE:UserStats.UNENABLE);
        return retCustomer;
    }

    private Customer writeInfIntoCustomer(Customer cus, CustomerInf inf) {
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
        cus.setPhontNum(inf.getMobilePhone());
        cus.setEmail(inf.getCustomerEmail());
        if (inf.getGender() == "1") {
            cus.setGender(Gender.MALE);
        } else {
            cus.setGender(Gender.FAMALE);
        }
        cus.setUser_point(inf.getUserPoint());
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

    private CustomerAddr daoAddrTopojoAddr(com.kermi.market.userservice.dao.CustomerAddr addr) {
        CustomerAddr pojoAddr = new CustomerAddr();
        if (addr.getZip() != null) {
            pojoAddr.setZip(addr.getZip());
        }
        if (addr.getProvince() != null) {
            pojoAddr.setProvince(addr.getProvince());
        }
        if (addr.getCity() != null) {
            pojoAddr.setCity(addr.getCity());
        }
        if (addr.getDistrict() != null) {
            pojoAddr.setDistrict(addr.getDistrict());
        }
        if (addr.getAddress() != null) {
            pojoAddr.setAddress(addr.getAddress());
        }
        if (addr.getIsDefault() == 1) {
            pojoAddr.setDefault(true);
        } else {
            pojoAddr.setDefault(false);
        }
        return pojoAddr;
    }

    private com.kermi.market.userservice.dao.CustomerAddr pojoAddrToDaoAddr(String UUID, CustomerAddr addr) {
        com.kermi.market.userservice.dao.CustomerAddr retdaoaddr = new com.kermi.market.userservice.dao.CustomerAddr();
        retdaoaddr.setCustomerId(UUID);
        if (addr.getZip() != 0) {
            retdaoaddr.setZip(addr.getZip());
        }
        if (addr.getProvince() != null) {
            retdaoaddr.setProvince(addr.getProvince());
        }
        if (addr.getCity() != null) {
            retdaoaddr.setCity(addr.getCity());
        }
        if (addr.getDistrict() != null) {
            retdaoaddr.setDistrict(addr.getDistrict());
        }
        if (addr.getAddress() != null) {
            retdaoaddr.setAddress(addr.getAddress());
        }
        if (addr.isDefault()) {
            retdaoaddr.setIsDefault((byte) 1);
        } else {
            retdaoaddr.setIsDefault((byte) 0);
        }

        return retdaoaddr;
    }

    private void saveCustomerToRedis(Customer customer){
        try {
            RedisUtil.save(prefixUUID + customer.getUUID(), customer);
            logger.info("Redis存入值:" + prefixUUID + customer.getUUID());
            RedisUtil.save(prefixName + customer.getLoginUserName(), customer);
            logger.info("Redis存入值:" + prefixName + customer.getLoginUserName());
        } catch (Exception e) {
            logger.error("UserAddrService Redis Error");
        }
    }
}
