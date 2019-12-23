package com.kermi.market.goodsservice.mapper;


import com.kermi.market.goodsservice.dao.ProductCategory;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface ProductCategoryMapper {
    int deleteByPrimaryKey(Short categoryId);

    int insert(ProductCategory record);

    int insertSelective(ProductCategory record);

    ProductCategory selectByPrimaryKey(Short categoryId);

    List<ProductCategory> selectCategoryByParentId(Integer parent_id);

    int updateByPrimaryKeySelective(ProductCategory record);

    int updateByPrimaryKey(ProductCategory record);

    int selectDeepestLevel();
}