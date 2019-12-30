package com.kermi.market.marketevent.mapper;

import com.kermi.market.marketevent.pojo.WarehouseInfo;

public interface WarehouseInfoMapper {
    int deleteByPrimaryKey(Short wId);

    int insert(WarehouseInfo record);

    int insertSelective(WarehouseInfo record);

    WarehouseInfo selectByPrimaryKey(Short wId);

    int updateByPrimaryKeySelective(WarehouseInfo record);

    int updateByPrimaryKey(WarehouseInfo record);
}