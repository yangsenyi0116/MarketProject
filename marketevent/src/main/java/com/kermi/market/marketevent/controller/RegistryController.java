package com.kermi.market.marketevent.controller;


import com.kermi.market.marketevent.pojo.CustomerLogin;
import com.kermi.market.marketevent.service.LoginService;
import com.kermi.market.marketevent.service.RegistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class RegistryController {
    @Autowired
    RegistryService registryService;

    @Autowired
    LoginService loginService;

    @RequestMapping("/registercustomer")
    public  boolean registerCustomer( CustomerLogin customerLogin){
        return registryService.RegistryNewCustomer(customerLogin);
    }
    @RequestMapping("/test")
    public String test(){
        if(loginService.test("abcd").getLoginName().equals("bb")) {
            return "true";
        }
        else {
            return "false";
        }
    }
}
