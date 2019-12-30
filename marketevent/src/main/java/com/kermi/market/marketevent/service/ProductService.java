package com.kermi.market.marketevent.service;

import com.kermi.market.marketevent.pojo.ProductCategory;
import com.kermi.market.marketevent.pojo.ProductComment;
import com.kermi.market.marketevent.pojo.ProductInfo;
import com.kermi.market.marketevent.pojo.ProductPicInfo;

import java.util.List;

public interface ProductService {




    List<ProductCategory> findAllProductCategory();
    List<ProductComment> findAllProductComment();
    List<ProductInfo> findAllProductInfo();
    List<ProductPicInfo> findAllProductPicInfo();

    ProductCategory findByCategoryId(short id);

    ProductComment  findByCommentId(Integer id);

    ProductInfo findByProductId(Integer id);

    ProductPicInfo findByProductPicId(Integer id);
}
