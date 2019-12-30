package com.kermi.market.marketevent.service.impl;

import com.kermi.market.marketevent.mapper.CustomerLoginMapper;
import com.kermi.market.marketevent.pojo.CustomerLogin;
import com.kermi.market.marketevent.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    CustomerLoginMapper customerLoginMapper;

    @Override
    public CustomerLogin login(CustomerLogin customer) {

        customerLoginMapper.selectByPrimaryKey(customer.getCustomerId());
        return customer;
    }

    @Override
    public CustomerLogin test(String id) {
        CustomerLogin customer = customerLoginMapper.selectByPrimaryKey(id);
        return customer;
    }

    @Override
    public CustomerLogin test() {
        return null;
    }
}
