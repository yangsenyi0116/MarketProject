package com.kermi.market.marketevent.mapper;

import com.kermi.market.marketevent.pojo.OrderCart;

public interface OrderCartMapper {
    int deleteByPrimaryKey(Integer cartId);

    int insert(OrderCart record);

    int insertSelective(OrderCart record);

    OrderCart selectByPrimaryKey(Integer cartId);

    int updateByPrimaryKeySelective(OrderCart record);

    int updateByPrimaryKey(OrderCart record);
}