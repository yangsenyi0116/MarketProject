package com.kermi.market.marketevent.mapper;

import com.kermi.market.marketevent.pojo.CustomerLogin;

public interface CustomerLoginMapper {
    int deleteByPrimaryKey(String customerId);

    int insert(CustomerLogin record);

    int insertSelective(CustomerLogin record);

    CustomerLogin selectByPrimaryKey(String customerId);

    int updateByPrimaryKeySelective(CustomerLogin record);

    int updateByPrimaryKey(CustomerLogin record);

    CustomerLogin selectByUsernameAndPwd(CustomerLogin customerLogin);
}