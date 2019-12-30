package com.kermi.market.marketevent.mapper;

import com.kermi.market.marketevent.pojo.ProductComment;

import java.util.List;

public interface ProductCommentMapper {
    int deleteByPrimaryKey(Integer commentId);

    int insert(ProductComment record);

    int insertSelective(ProductComment record);

    ProductComment selectByPrimaryKey(Integer commentId);
    List<ProductComment> findAllProductComment();


    int updateByPrimaryKeySelective(ProductComment record);

    int updateByPrimaryKey(ProductComment record);
}