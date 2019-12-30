package com.kermi.market.marketevent.mapper;

import com.kermi.market.marketevent.pojo.BrandInfo;


public interface BrandInfoMapper {
    int deleteByPrimaryKey(Short brandId);

    int insert(BrandInfo record);

    int insertSelective(BrandInfo record);

    BrandInfo selectByPrimaryKey(Short brandId);

    int updateByPrimaryKeySelective(BrandInfo record);

    int updateByPrimaryKey(BrandInfo record);
}