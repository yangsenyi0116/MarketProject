package com.kermi.market.marketevent.mapper;

import com.kermi.market.marketevent.pojo.CustomerLoginLog;

public interface CustomerLoginLogMapper {
    int deleteByPrimaryKey(Integer loginId);

    int insert(CustomerLoginLog record);

    int insertSelective(CustomerLoginLog record);

    CustomerLoginLog selectByPrimaryKey(Integer loginId);

    int updateByPrimaryKeySelective(CustomerLoginLog record);

    int updateByPrimaryKey(CustomerLoginLog record);

}