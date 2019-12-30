package com.kermi.market.marketevent.mapper;

import com.kermi.market.marketevent.pojo.ArchCustomerLoginLog;

public interface ArchCustomerLoginLogMapper {
    int deleteByPrimaryKey(Integer loginId);

    int insert(ArchCustomerLoginLog record);

    int insertSelective(ArchCustomerLoginLog record);

    ArchCustomerLoginLog selectByPrimaryKey(Integer loginId);

    int updateByPrimaryKeySelective(ArchCustomerLoginLog record);

    int updateByPrimaryKey(ArchCustomerLoginLog record);
}