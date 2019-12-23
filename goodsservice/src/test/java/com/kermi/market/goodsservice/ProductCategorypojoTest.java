package com.kermi.market.goodsservice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Kermi
 * @Date : 2019/12/17 21:11
 * @Version : 1.0
 */
public class ProductCategorypojoTest {


    @Test
    public void pojotest(){
        List<String> a = new ArrayList<>();
        a.add("1");
        a.add("2");
        List<String> b = new ArrayList<>();
        b.add("a");
        b.add("a2");
        List<String> c = new ArrayList<>();
        c.add("b");
        c.add("b2");
        List<List<String>> lists = new ArrayList<>();
        lists.add(a);
        Object o = lists.get(0);
        System.out.println(o instanceof List);
        for (String str:(List<String>) o){
            System.out.println(str);
        }
    }
}
