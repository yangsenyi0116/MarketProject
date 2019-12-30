package com.kermi.market.marketevent.service.impl;

import com.kermi.market.marketevent.mapper.CustomerLoginMapper;
import com.kermi.market.marketevent.pojo.CustomerLogin;
import com.kermi.market.marketevent.service.RegistryService;
import com.kermi.market.marketevent.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RegistryServiceImpl implements RegistryService {


    @Autowired
    CustomerLoginMapper customerLoginMapper;

    @Override
    public boolean RegistryNewCustomer(CustomerLogin customerLogin) {
        customerLogin.setCustomerId(UUIDUtils.uuid());
        try {
            customerLoginMapper.insertSelective(customerLogin);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
