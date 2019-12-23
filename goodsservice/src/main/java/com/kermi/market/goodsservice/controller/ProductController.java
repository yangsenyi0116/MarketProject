package com.kermi.market.goodsservice.controller;

import com.kermi.market.goodsservice.dao.ProductCategory;
import com.kermi.market.goodsservice.service.ProductCategoryService;
import com.kermi.market.goodsservice.untils.ResponseCode;
import com.kermi.market.goodsservice.untils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author : Kermi
 * @Date : 2019/12/17 21:13
 * @Version : 1.0
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductCategoryService categoryService;

    private Object data;
    private String error;

    @RequestMapping("/getCategory/{parentId}")
    public ResponseUtils getCategory(@PathVariable("parentId") int parentid){
        data = categoryService.getLeveLCategory(parentid);
        error = null;
        return retRes(ResponseCode.SUCCESS, data, error);
    }

    private ResponseUtils retRes(ResponseCode code, Object data, String error) {
        return new ResponseUtils(code, data, error);
    }
}
