package com.kermi.market.userservice.mapper;

import com.kermi.market.userservice.dao.ShippingInfo;

public interface ShippingInfoMapper {
    int deleteByPrimaryKey(Byte shipId);

    int insert(ShippingInfo record);

    int insertSelective(ShippingInfo record);

    ShippingInfo selectByPrimaryKey(Byte shipId);

    int updateByPrimaryKeySelective(ShippingInfo record);

    int updateByPrimaryKey(ShippingInfo record);
}