package com.kermi.market.goodsservice.service;

import com.kermi.market.goodsservice.dao.ProductCategory;

import java.util.List;

/**
 * @Author : Kermi
 * @Date : 2019/12/17 21:22
 * @Version : 1.0
 */
public interface ProductCategoryService {

    /**
     * 获取一个父类下边的所有子类
     * @param parentid 父类的id
     * @return
     */
    List<ProductCategory> getLeveLCategory(int parentid);
}
