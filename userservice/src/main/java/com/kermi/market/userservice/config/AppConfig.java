package com.kermi.market.userservice.config;

import com.kermi.market.userservice.dao.CustomerLogin;
import com.kermi.market.userservice.pojo.Customer;
import com.kermi.market.userservice.untils.ResponseUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author : Kermi
 * @Date : 2019/12/10 21:31
 * @Version : 1.0
 */
@Configuration
public class AppConfig {

    @Bean(name = "customer")
    public Customer getCustomer() {
        return new Customer();
    }

    @Bean(name = "customerLogin")
    public CustomerLogin getCustomerLogin(){
        return new CustomerLogin();
    }

    @Bean(name = "responseBody")
    public ResponseUtils getResponse() {
        return new ResponseUtils();
    }
}
