package com.kermi.market.marketevent.service.impl;

import com.kermi.market.marketevent.mapper.ProductCategoryMapper;
import com.kermi.market.marketevent.mapper.ProductCommentMapper;
import com.kermi.market.marketevent.mapper.ProductInfoMapper;
import com.kermi.market.marketevent.mapper.ProductPicInfoMapper;
import com.kermi.market.marketevent.pojo.ProductCategory;
import com.kermi.market.marketevent.pojo.ProductComment;
import com.kermi.market.marketevent.pojo.ProductInfo;
import com.kermi.market.marketevent.pojo.ProductPicInfo;
import com.kermi.market.marketevent.redis.JedisClient;
import com.kermi.market.marketevent.service.ProductService;
import com.kermi.market.marketevent.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class ProductServiceImpl  implements ProductService {
    @Autowired
    ProductCategoryMapper productCategoryMapper;

    @Autowired
    ProductCommentMapper productCommentMapper;

    @Autowired
    ProductInfoMapper productInfoMapper;

    @Autowired
    ProductPicInfoMapper productPicInfoMapper;

    @Autowired
    JedisClient jedisClient;

    @Value("${myredis.CATEGORY_KEY1}")
    private String CATEGORY_KEY1;
    @Value("${myredis.COMMENT_KEY}")
    private String COMMENT_KEY;
    @Value("${myredis.PRODUCTINFO_KEY}")
    private String PRODUCTINFO_KEY;
    @Value("${myredis.PRODUCTPICINFO_KEY}")
    private String PRODUCTPICINFO_KEY;

    @Override
    public List<ProductCategory> findAllProductCategory() {
        try {
            String datas = jedisClient.hget("CATEGORY_KEY1", "TOP_LEVEL2");
            if (Objects.nonNull(datas) && !datas.matches("^\\s*$")) {
                log.info("------从缓存中读取------");
                List<ProductCategory> lists= JsonUtils.jsonToList(datas,ProductCategory.class);
                return lists;
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
        }

        List<ProductCategory> ProductCategories = productCategoryMapper.findAllProductCategory();
        log.info(ProductCategories.toString());

        try {
            jedisClient.hset("CATEGORY_KEY1", "TOP_LEVEL2", JsonUtils.objectToJson(ProductCategories));
            log.info("注入redis");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return ProductCategories;
    }


    @Override
    public List<ProductComment> findAllProductComment() {
        try {
            String datas = jedisClient.hget("COMMENT_KEY", "TOP_LEVEL");
            if (Objects.nonNull(datas) && !datas.matches("^\\s*$")) {
                log.info("------从缓存中读取------");
                List<ProductComment> lists= JsonUtils.jsonToList(datas,ProductComment.class);
                return lists;
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
        }

        List<ProductComment> ProductComments = productCommentMapper.findAllProductComment();
        log.info(ProductComments.toString());

        try {
            jedisClient.hset("COMMENT_KEY", "TOP_LEVEL", JsonUtils.objectToJson(ProductComments));
            log.info("注入redis");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return ProductComments;
    }

    @Override
    public List<ProductInfo> findAllProductInfo() {
        try {
            String datas = jedisClient.hget("PRODUCTINFO_KEY", "TOP_LEVEL");
            if (Objects.nonNull(datas) && !datas.matches("^\\s*$")) {
                log.info("------从缓存中读取------");
                List<ProductInfo> lists= JsonUtils.jsonToList(datas,ProductInfo.class);
                return lists;
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
        }

        List<ProductInfo> ProductInfos = productInfoMapper.findAllProductInfo();
        log.info(ProductInfos.toString());

        try {
            jedisClient.hset("PRODUCTINFO_KEY", "TOP_LEVEL", JsonUtils.objectToJson(ProductInfos));
            log.info("注入redis");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return ProductInfos;
    }

    @Override
    public List<ProductPicInfo> findAllProductPicInfo() {
        try {
            String datas = jedisClient.hget("PRODUCTPICINFO_KEY", "TOP_LEVEL");
            if (Objects.nonNull(datas) && !datas.matches("^\\s*$")) {
                log.info("------从缓存中读取------");
                List<ProductPicInfo> lists= JsonUtils.jsonToList(datas,ProductPicInfo.class);
                return lists;
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
        }

        List<ProductPicInfo> ProductPicInfos = productPicInfoMapper.findAllProductPicInfo();
        log.info(ProductPicInfos.toString());

        try {
            jedisClient.hset("PRODUCTPICINFO_KEY", "TOP_LEVEL", JsonUtils.objectToJson(ProductPicInfos));
            log.info("注入redis");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return ProductPicInfos;
    }

    @Override
    public ProductCategory findByCategoryId(short id) {

        try {
            String datas = jedisClient.hget("CATEGORY_KEY1", "TOP_LEVEL1");
            if (Objects.nonNull(datas) && !datas.matches("^\\s*$")) {
                log.info("------从缓存中读取------");
                ProductCategory productCategory= JsonUtils.jsonToPojo(datas,ProductCategory.class);
                return productCategory;
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
        }

        ProductCategory productCategory = productCategoryMapper.selectByPrimaryKey(id);
        log.info(productCategory.toString());

        try {
            jedisClient.hset("CATEGORY_KEY1", "TOP_LEVEL1", JsonUtils.objectToJson(productCategory));
            log.info("注入redis");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return productCategory;
    }


    @Override
    public ProductComment findByCommentId(Integer id) {

        try {
            String datas = jedisClient.hget("COMMENT_KEY", "TOP_LEVEL1");
            if (Objects.nonNull(datas) && !datas.matches("^\\s*$")) {
                log.info("------从缓存中读取------");
                ProductComment productComment= JsonUtils.jsonToPojo(datas,ProductComment.class);
                return productComment;
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
        }

        ProductComment productComment = productCommentMapper.selectByPrimaryKey(id);
        log.info(productComment.toString());

        try {
            jedisClient.hset("COMMENT_KEY", "TOP_LEVEL1", JsonUtils.objectToJson(productComment));
            log.info("注入redis");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return productComment;
    }

    @Override
    public ProductInfo findByProductId(Integer id) {

        try {
            String datas = jedisClient.hget("PRODUCTINFO_KEY", "TOP_LEVEL1");
            if (Objects.nonNull(datas) && !datas.matches("^\\s*$")) {
                log.info("------从缓存中读取------");
                ProductInfo productInfo= JsonUtils.jsonToPojo(datas,ProductInfo.class);
                return productInfo;
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
        }

        ProductInfo productInfo = productInfoMapper.selectByPrimaryKey(id);
        log.info(productInfo.toString());

        try {
            jedisClient.hset("PRODUCTINFO_KEY", "TOP_LEVEL1", JsonUtils.objectToJson(productInfo));
            log.info("注入redis");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return productInfo;
    }

    @Override
    public ProductPicInfo findByProductPicId(Integer id) {

        try {
            String datas = jedisClient.hget("PRODUCTPICINFO_KEY", "TOP_LEVEL1");
            if (Objects.nonNull(datas) && !datas.matches("^\\s*$")) {
                log.info("------从缓存中读取------");
                ProductPicInfo productPicInfo= JsonUtils.jsonToPojo(datas,ProductPicInfo.class);
                return productPicInfo;
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
        }

        ProductPicInfo productPicInfo = productPicInfoMapper.selectByPrimaryKey(id);
        log.info(productPicInfo.toString());

        try {
            jedisClient.hset("PRODUCTPICINFO_KEY", "TOP_LEVEL1", JsonUtils.objectToJson(productPicInfo));
            log.info("注入redis");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return productPicInfo;
    }
}
