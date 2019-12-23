package com.kermi.market.userservice.mapper;

import com.kermi.market.userservice.dao.ArchCustomerLoginLog;

public interface ArchCustomerLoginLogMapper {
    int deleteByPrimaryKey(Integer loginId);

    int insert(ArchCustomerLoginLog record);

    int insertSelective(ArchCustomerLoginLog record);

    ArchCustomerLoginLog selectByPrimaryKey(Integer loginId);

    int updateByPrimaryKeySelective(ArchCustomerLoginLog record);

    int updateByPrimaryKey(ArchCustomerLoginLog record);
}