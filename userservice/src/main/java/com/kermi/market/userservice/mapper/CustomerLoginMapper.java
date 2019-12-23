package com.kermi.market.userservice.mapper;

import com.kermi.market.userservice.dao.CustomerLogin;
import com.kermi.market.userservice.pojo.Customer;
import org.springframework.stereotype.Component;


@Component
public interface CustomerLoginMapper {
    int deleteByPrimaryKey(String customerId);

    int insert(CustomerLogin record);

    int insertSelective(CustomerLogin record);

    CustomerLogin selectByPrimaryKey(String customerId);

    int updateByPrimaryKeySelective(CustomerLogin record);

    int updateByPrimaryKey(CustomerLogin record);

    String selectByLoginName(String login_name);

    CustomerLogin querySelective(CustomerLogin record);

}