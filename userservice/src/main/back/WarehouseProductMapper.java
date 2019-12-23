package com.kermi.market.userservice.mapper;

import com.kermi.market.userservice.dao.WarehouseProduct;

public interface WarehouseProductMapper {
    int deleteByPrimaryKey(Integer wpId);

    int insert(WarehouseProduct record);

    int insertSelective(WarehouseProduct record);

    WarehouseProduct selectByPrimaryKey(Integer wpId);

    int updateByPrimaryKeySelective(WarehouseProduct record);

    int updateByPrimaryKey(WarehouseProduct record);
}