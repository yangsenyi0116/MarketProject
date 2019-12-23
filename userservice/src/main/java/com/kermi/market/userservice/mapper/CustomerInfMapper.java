package com.kermi.market.userservice.mapper;

import com.kermi.market.userservice.dao.CustomerInf;
import org.springframework.stereotype.Component;

@Component
public interface CustomerInfMapper {

    int deleteByPrimaryKey(Integer customerInfId);

    int insert(CustomerInf record);

    int insertSelective(CustomerInf record);

    CustomerInf selectByPrimaryKey(Integer customerInfId);

    int updateByPrimaryKeySelective(CustomerInf record);

    int updateByPrimaryKey(CustomerInf record);

    CustomerInf selectByUUID(String cusUUID);
}