package com.kermi.market.marketevent.mapper;

import com.kermi.market.marketevent.pojo.CustomerBalanceLog;

public interface CustomerBalanceLogMapper {
    int deleteByPrimaryKey(Integer balanceId);

    int insert(CustomerBalanceLog record);

    int insertSelective(CustomerBalanceLog record);

    CustomerBalanceLog selectByPrimaryKey(Integer balanceId);

    int updateByPrimaryKeySelective(CustomerBalanceLog record);

    int updateByPrimaryKey(CustomerBalanceLog record);
}