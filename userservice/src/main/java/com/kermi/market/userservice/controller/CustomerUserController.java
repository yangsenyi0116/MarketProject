package com.kermi.market.userservice.controller;


import com.kermi.market.userservice.config.AppConfig;
import com.kermi.market.userservice.pojo.Customer;
import com.kermi.market.userservice.pojo.SessionAttributes;
import com.kermi.market.userservice.service.SessionService;
import com.kermi.market.userservice.service.UserService;
import com.kermi.market.userservice.untils.ResponseCode;
import com.kermi.market.userservice.untils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author : Kermi
 * @Date : 2019/12/10 21:24
 * @Version : 1.0
 */
@RestController
@RequestMapping("/customer")
public class CustomerUserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SessionService sessionService;

    private static Object data=null;
    private static String error=null;

    /**
     * 注册用户
     * @param login_name 用于登录的用户名
     * @param md5password md5加密的密码
     * @return ResponseUtils方法类
     */
    @RequestMapping("/regist/{loginName}/{password}")
    public ResponseUtils registNewCustomer(@PathVariable("loginName") String login_name,
                                      @PathVariable("password") String md5password) {
        Customer newCustomer = new Customer();
        newCustomer.setLoginUserName(login_name);
        if (isExit(newCustomer.getLoginUserName())){
            data = null;
            StringBuffer error = new StringBuffer("用户");error.append(login_name);error.append("已存在");
            return retRes(ResponseCode.SUCCESS,data,error.toString());
        }
        newCustomer.setPassword(md5password);
        boolean flag = userService.registeNewCustomer(newCustomer.getLoginUserName(), newCustomer.getPassword());
        if (!flag){
            data = null;
            error = "服务器错误";
            return retRes(ResponseCode.SERVICE_ERROR, data, error);
        }
        StringBuilder successMessage = new StringBuilder("用户");successMessage.append(login_name);successMessage.append("注册成功");
        data = successMessage.toString();
        error = null;
        return retRes(ResponseCode.SUCCESS, data, error);
    }

    /**
     * 登录
     * @param login_name 用户名
     * @param md5password 密码
     * @param request HttpServletRequest对象用与获取SessionId
     * @return ResponseUtils方法类
     */
    @RequestMapping("/login/{loginName}/{password}")
    public ResponseUtils loginCustomer(@PathVariable("loginName") String login_name,
                                       @PathVariable("password") String md5password,
                                       HttpServletRequest request) {
        Customer loginCustomer = new Customer();
        loginCustomer.setLoginUserName(login_name);
        if (!isExit(loginCustomer.getLoginUserName())) {
            //用户名不存在返回错误信息
            data = null;
            StringBuffer sb = new StringBuffer("用户");sb.append(loginCustomer.getLoginUserName());sb.append("不存在");
            error = sb.toString();
            return retRes(ResponseCode.SUCCESS,data,error);
        }
        loginCustomer.setPassword(md5password);
        Customer customer = userService.loginUser(loginCustomer);
        if (customer == null) {
            //密码错误
            data = null;
            StringBuffer sb = new StringBuffer("密码错误");
            error = sb.toString();
            return retRes(ResponseCode.SUCCESS,data,error);
        }
        //密码正确
        data = customer;
        //向SessionAttributes中写值
        SessionAttributes attributes = new SessionAttributes(getSessionID(request),customer.getUUID(),customer.getLoginUserName());
        //将Session值写入Redis中2
        sessionService.writeSessionAttributesToRedis(attributes);
        return retRes(ResponseCode.SUCCESS,data,null);
    }

    /**
     * 检查用户是否存在
     * @param login_name 用户名
     * @return true of false
     */
    @RequestMapping("/isExist/{loginName}")
    public boolean isExit(@PathVariable("loginName") String login_name) {
        return userService.checkforExist(login_name);
    }


    /**
     * 从Redis缓存中获取Sessionid
     * @param request HttpServletRequest对象
     * @return SessionAttributes对象
     */
    public SessionAttributes getSessionAttributes(HttpServletRequest request) {
        return sessionService.getSessionAttributesFromRedis(request.getSession().getId());
    }

    private String getSessionID(HttpServletRequest request) {
        return request.getSession().getId();
    }

    private ResponseUtils retRes(ResponseCode code,Object data,String error) {
        return new ResponseUtils(code,data,error);
    }
}
