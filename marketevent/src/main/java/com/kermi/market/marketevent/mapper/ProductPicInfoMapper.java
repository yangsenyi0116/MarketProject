package com.kermi.market.marketevent.mapper;

import com.kermi.market.marketevent.pojo.ProductPicInfo;

import java.util.List;

public interface ProductPicInfoMapper {
    int deleteByPrimaryKey(Integer productPicId);

    int insert(ProductPicInfo record);

    int insertSelective(ProductPicInfo record);

    ProductPicInfo selectByPrimaryKey(Integer productPicId);

    List<ProductPicInfo> findAllProductPicInfo();

    int updateByPrimaryKeySelective(ProductPicInfo record);

    int updateByPrimaryKey(ProductPicInfo record);
}