package com.kermi.market.userservice.service;

import com.kermi.market.userservice.dao.CustomerLogin;
import com.kermi.market.userservice.pojo.Customer;
import com.kermi.market.userservice.pojo.SessionAttributes;

/**
 * @Author : Kermi
 * @Date : 2019/12/10 20:37
 * @Version : 1.0
 */
public interface UserService {
    /**
     * 检查用户名是否存在与数据库
     * @param login_name
     * @return
     */
    boolean checkforExist(String login_name);

    /**
     * 向数据库中写入新数据
     * @param login_name
     * @param md5password
     * @return
     * */
    boolean registeNewCustomer(String login_name, String md5password);

    /**
     * 用户登录，用于判断传过来的用户名和密码是否正确，如果正确返回Customer对象
     * @param loginCustomer
     * @return
     * */
    Customer loginUser(Customer loginCustomer);

}
