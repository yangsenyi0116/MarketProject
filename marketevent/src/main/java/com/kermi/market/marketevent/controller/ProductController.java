package com.kermi.market.marketevent.controller;
import com.kermi.market.marketevent.entity.StatusCode;
import com.kermi.market.marketevent.entity.Result;
import com.kermi.market.marketevent.pojo.ProductCategory;
import com.kermi.market.marketevent.pojo.ProductComment;
import com.kermi.market.marketevent.pojo.ProductInfo;
import com.kermi.market.marketevent.pojo.ProductPicInfo;
import com.kermi.market.marketevent.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

 @Autowired
    ProductService productService;
    @RequestMapping("/category")
    public Result showAllProductCategory(Model model){
        List<ProductCategory> productCategories= productService.findAllProductCategory();
        model.addAttribute("productCategories",productCategories);
        return new Result(true, StatusCode.OK,"查询成功",productCategories);
    }

 @RequestMapping(value = "/category/{categoryid}" ,method = RequestMethod.GET)
 public Result showProductCategory(@PathVariable("categoryid") short categoryid, Model model){
     ProductCategory productCategory= productService.findByCategoryId(categoryid);
     model.addAttribute("productCategory",productCategory);
     return new Result(true,StatusCode.OK,"查询成功",productCategory);
 }

    @RequestMapping("/comment")
    public Result showAllProductComment(Model model){
        List<ProductComment> productComments= productService.findAllProductComment();
        model.addAttribute("productComments",productComments);
        return new Result(true,StatusCode.OK,"查询成功",productComments);
    }
 @RequestMapping("/comment/{commentid}")
    public Result showProductComment(@PathVariable("commentid") Integer commentid,Model model){
     ProductComment productComment= productService.findByCommentId(commentid);
     model.addAttribute("productComment",productComment);
     return new Result(true,StatusCode.OK,"查询成功",productComment);
 }

    @RequestMapping("/info")
    public Result showProductInfo(Model model){
        List<ProductInfo> productInfos= productService.findAllProductInfo();
        model.addAttribute("productInfos",productInfos);
        return new Result(true,StatusCode.OK,"查询成功",productInfos);
    }
    @RequestMapping("/info/{infoid}")
    public Result showProductInfo(@PathVariable("infoid")Integer infoid,Model model){
        ProductInfo productInfo= productService.findByProductId(infoid);
        model.addAttribute("productInfo",productInfo);
        return new Result(true,StatusCode.OK,"查询成功",productInfo);
    }

    @RequestMapping("/picinfo")
    public Result showProductPicInfo(Model model){
        List<ProductPicInfo> productPicInfos= productService.findAllProductPicInfo();
        model.addAttribute("productPicInfos",productPicInfos);
        return new Result(true,StatusCode.OK,"查询成功",productPicInfos);
    }
    @RequestMapping("/picinfo/{picinfoid}")
    public Result showProductPicInfo(@PathVariable("picinfoid")Integer picinfoid,Model model){
        ProductPicInfo productPicInfo= productService.findByProductPicId(picinfoid);
        model.addAttribute("productPicInfo",productPicInfo);
        return new Result(true,StatusCode.OK,"查询成功",productPicInfo);
    }

}
