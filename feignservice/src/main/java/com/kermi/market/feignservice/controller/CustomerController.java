package com.kermi.market.feignservice.controller;

import com.kermi.market.feignservice.serviceinterface.CustomerService;
import com.kermi.market.feignservice.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author : Kermi
 * @Date : 2019/12/16 23:24
 * @Version : 1.0
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping("/isExist/{username}")
    boolean isExist(@PathVariable("username") String username) {
        return customerService.isExist(username);
    }

    @RequestMapping("/login/{username}/{password}")
    ResponseUtils login(@PathVariable("username") String username, @PathVariable("password") String md5password) {
        return customerService.login(username, md5password);
    }

    @RequestMapping("/regist/{username}/{password}")
    ResponseUtils regist(@PathVariable("username") String username, @PathVariable("password") String md5password) {
        return customerService.regist(username, md5password);
    }

    @RequestMapping("/getUserInfo")
    ResponseUtils getCusInfo() {
        return customerService.getCusInfo();
    }

    @RequestMapping("/getDefaultAddr")
    ResponseUtils getDefaultAddr() {
        return customerService.getDefaultAddr();
    }

    @RequestMapping("/getAllAddr")
    ResponseUtils getAllAddr() {
        return customerService.getAllAddr();
    }
}
