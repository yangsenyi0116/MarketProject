package com.kermi.market.goodsservice.service.impl;

import com.kermi.market.goodsservice.dao.ProductCategory;
import com.kermi.market.goodsservice.mapper.ProductCategoryMapper;
import com.kermi.market.goodsservice.pojo.ProductCategoryRedispojo;
import com.kermi.market.goodsservice.service.ProductCategoryService;
import com.kermi.market.goodsservice.untils.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Kermi
 * @Date : 2019/12/17 21:24
 * @Version : 1.0
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private static final Logger logger = LoggerFactory.getLogger(ProductCategoryService.class);

    @Autowired
    ProductCategoryMapper categoryMapper;

    @Value("${redis.name.categoryprefixParentID}")
    private String categoryprefixParentID;

    @Override
    public List<ProductCategory> getLeveLCategory(int parentid){
        List<ProductCategory> categoryList = null;
        ProductCategoryRedispojo redispojo = null;
        try {
            redispojo= (ProductCategoryRedispojo) RedisUtil.get(categoryprefixParentID + parentid);
            logger.info("Redis取值:" + categoryprefixParentID + parentid);
        }catch (Exception e){
            logger.error("ProductCategoryService Redis Error");
        }

        if (redispojo == null) {
            categoryList = categoryMapper.selectCategoryByParentId(parentid);
            redispojo = new ProductCategoryRedispojo();
            redispojo.setParentId(parentid);
            if (categoryList == null) {
                //为空，取不到值
                return null;
            }
            List<ProductCategory> inlist = new ArrayList<>();
            for (ProductCategory category : categoryList) {
                inlist.add(category);
            }
            redispojo.setList(inlist);
            try {
                RedisUtil.save(categoryprefixParentID + parentid, redispojo);
                logger.info("Redis存值:" + categoryprefixParentID + parentid);
            }catch (Exception e){
                logger.error("ProductCategoryService Redis Error");
            }
        }

        categoryList = redispojo.getList();

        return categoryList;
    }

    private int getDeepestLevel() {
        return categoryMapper.selectDeepestLevel();
    }
}
