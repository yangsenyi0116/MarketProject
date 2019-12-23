package com.kermi.market.userservice.mapper;

import com.kermi.market.userservice.dao.WarehouseInfo;

public interface WarehouseInfoMapper {
    int deleteByPrimaryKey(Short wId);

    int insert(WarehouseInfo record);

    int insertSelective(WarehouseInfo record);

    WarehouseInfo selectByPrimaryKey(Short wId);

    int updateByPrimaryKeySelective(WarehouseInfo record);

    int updateByPrimaryKey(WarehouseInfo record);
}