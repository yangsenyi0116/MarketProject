package com.kermi.market.goodsservice.pojo;

import com.kermi.market.goodsservice.dao.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Author : Kermi
 * @Date : 2019/12/18 11:18
 * @Version : 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategoryRedispojo implements Serializable {
    private int parentId;

    private List<ProductCategory> list;
}
