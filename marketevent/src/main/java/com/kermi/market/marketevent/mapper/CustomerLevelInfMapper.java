package com.kermi.market.marketevent.mapper;

import com.kermi.market.marketevent.pojo.CustomerLevelInf;

public interface CustomerLevelInfMapper {
    int deleteByPrimaryKey(Byte customerLevel);

    int insert(CustomerLevelInf record);

    int insertSelective(CustomerLevelInf record);

    CustomerLevelInf selectByPrimaryKey(Byte customerLevel);

    int updateByPrimaryKeySelective(CustomerLevelInf record);

    int updateByPrimaryKey(CustomerLevelInf record);
}