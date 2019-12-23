package com.kermi.market.feignservice.serviceinterface;

import com.kermi.market.feignservice.pojo.CustomerAddr;
import com.kermi.market.feignservice.pojo.CustomerInfoFromWeb;
import com.kermi.market.feignservice.utils.ResponseUtils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @Author : Kermi
 * @Date : 2019/12/16 23:22
 * @Version : 1.0
 */

//@FeignClient(value = "userservice", fallback = SchedualCustomerServiceHystric.class)
@FeignClient("userservice")
public interface CustomerService {
    @RequestMapping(value = "/customer/isExist/{username}")
    boolean isExist(@PathVariable("username") String username);

    @RequestMapping(value = "/customer/login/{username}/{md5password}")
    ResponseUtils login(@PathVariable("username") String username, @PathVariable("md5password") String md5password);

    @RequestMapping(value = "/customer/regist/{username}/{md5password}")
    ResponseUtils regist(@PathVariable("username") String username, @PathVariable("md5password") String md5password);

    @RequestMapping(value = "/customer/getUserInfo")
    ResponseUtils getCusInfo();

    @RequestMapping(value = "/customer/setInfo", produces = "application/json;charset=utf-8")
    ResponseUtils setCusInfo(@RequestBody CustomerInfoFromWeb web);

    @RequestMapping(value = "/customer/getDefaultAddr")
    ResponseUtils getDefaultAddr();

    @RequestMapping(value = "/customer/getAllAddr")
    ResponseUtils getAllAddr();

    @RequestMapping(value = "/customer/setAddr", produces = "application/json;charset=utf-8")
    ResponseUtils setAddr(@RequestBody CustomerAddr web);
}
