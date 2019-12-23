package com.kermi.market.userservice.mapper;

import com.kermi.market.userservice.dao.CustomerLoginLog;

public interface CustomerLoginLogMapper {
    int deleteByPrimaryKey(Integer loginId);

    int insert(CustomerLoginLog record);

    int insertSelective(CustomerLoginLog record);

    CustomerLoginLog selectByPrimaryKey(Integer loginId);

    int updateByPrimaryKeySelective(CustomerLoginLog record);

    int updateByPrimaryKey(CustomerLoginLog record);
}