package com.kermi.market.userservice.controller;

import com.kermi.market.userservice.pojo.Customer;
import com.kermi.market.userservice.pojo.CustomerInfoFromWeb;
import com.kermi.market.userservice.pojo.SessionAttributes;
import com.kermi.market.userservice.service.SessionService;
import com.kermi.market.userservice.service.UserInfService;
import com.kermi.market.userservice.untils.ResponseCode;
import com.kermi.market.userservice.untils.ResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author : Kermi
 * @Date : 2019/12/12 22:01
 * @Version : 1.0
 */
@RestController
@RequestMapping("/customer")
public class CustomerInfoController {

    private Logger logger = LoggerFactory.getLogger(CustomerInfoController.class);

    @Autowired
    private UserInfService userInfService;

    @Autowired
    private SessionService sessionService;

    private Object data;
    private String error;

    /**
     *根据Session中的UUID去读取到相应的用户，并取值
     *@param request HttpServletRequest对象 用于获取Session
     * @return Customer对象
     */
    @RequestMapping("/getUserInfo")
    public ResponseUtils getCustomerInfo(HttpServletRequest request) {
        Customer customer = userInfService.getCustomer(getSessionId(request));
        ResponseUtils res = new ResponseUtils();
        if (customer == null) {
            data = null;
            error = "用户不存在";
            return retRes(ResponseCode.SERVICE_ERROR, data, error);
        }
        data = customer;
        error = null;
        return retRes(ResponseCode.SUCCESS, data, error);
    }

    @RequestMapping("/setInfo")
    public ResponseUtils setCustomerInfo(HttpServletRequest request,@RequestBody CustomerInfoFromWeb web) {
        //TODO 登录成功后从Session取出Customer对象,向对象中写入值

        logger.info(web.toString());

        SessionAttributes attributes = sessionService.getSessionAttributesFromRedis(getSessionId(request));
        if (attributes == null) {
            data = null;
            error = "请求参数错误";
            return retRes(ResponseCode.BADREQUEST, data, error);
        }
        Customer retcustomer = userInfService.setCustomerInfo(attributes,web);
        if (retcustomer == null) {
            data = null;
            error = "设置失败";
            return retRes(ResponseCode.BADREQUEST, data, error);
        }
        data=true;
        error=null;
        return retRes(ResponseCode.SUCCESS, data, error);
    }

    /**
     * 从request对象中取得当前SessionId的值
     * @param request HttpServletRequest对象
     * @return SessionId值
     */
    public String getSessionId(HttpServletRequest request) {
        return request.getSession().getId();
    }

    private ResponseUtils retRes(ResponseCode code,Object data,String error) {
        return new ResponseUtils(code,data,error);
    }
}
