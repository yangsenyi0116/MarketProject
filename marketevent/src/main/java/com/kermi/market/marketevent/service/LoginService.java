package com.kermi.market.marketevent.service;

import com.kermi.market.marketevent.pojo.CustomerLogin;

public interface LoginService {

    CustomerLogin login(CustomerLogin customer);

    CustomerLogin test(String id);
    CustomerLogin test();
}
