package com.kermi.market.userservice.mapper;

import com.kermi.market.userservice.dao.CustomerPointLog;

public interface CustomerPointLogMapper {
    int deleteByPrimaryKey(Integer pointId);

    int insert(CustomerPointLog record);

    int insertSelective(CustomerPointLog record);

    CustomerPointLog selectByPrimaryKey(Integer pointId);

    int updateByPrimaryKeySelective(CustomerPointLog record);

    int updateByPrimaryKey(CustomerPointLog record);
}