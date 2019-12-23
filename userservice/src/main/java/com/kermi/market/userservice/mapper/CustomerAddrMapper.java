package com.kermi.market.userservice.mapper;


import com.kermi.market.userservice.dao.CustomerAddr;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface CustomerAddrMapper {
    int deleteByPrimaryKey(Integer customerAddrId);

    int insert(CustomerAddr record);

    int insertSelective(CustomerAddr record);

    CustomerAddr selectByPrimaryKey(Integer customerAddrId);

    int updateByPrimaryKeySelective(CustomerAddr record);

    int updateByPrimaryKey(CustomerAddr record);

    List<CustomerAddr> querySelective(CustomerAddr addr);
}