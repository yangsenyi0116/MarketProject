package com.kermi.market.userservice.controller;

import com.kermi.market.userservice.pojo.CustomerAddr;
import com.kermi.market.userservice.pojo.SessionAttributes;
import com.kermi.market.userservice.service.SessionService;
import com.kermi.market.userservice.service.UserAddrService;
import com.kermi.market.userservice.untils.ResponseCode;
import com.kermi.market.userservice.untils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author : Kermi
 * @Date : 2019/12/15 22:04
 * @Version : 1.0
 */
@RestController
@RequestMapping("/customer")
public class CustomerAddrController {

    @Autowired
    private UserAddrService addrService;

    @Autowired
    private SessionService sessionService;

    private Object data;
    private String error;

    @RequestMapping("/getDefaultAddr")
    public ResponseUtils getDefaultAddr(HttpServletRequest request) {
        SessionAttributes attributes = sessionService.getSessionAttributesFromRedis(getSessionId(request));
        if (attributes == null) {
            data = null;
            error = "请求参数错误";
            return retRes(ResponseCode.BADREQUEST, data, error);
        }

        CustomerAddr customerAddr = addrService.getDefaultAddr(attributes);
        if (customerAddr == null) {
            data = "你没有设置默认地址";
            error = null;
            return retRes(ResponseCode.SUCCESS, data, error);
        }

        data = customerAddr;
        error = null;
        return retRes(ResponseCode.SUCCESS, data, error);
    }


    @RequestMapping("/getAllAddr")
    public ResponseUtils getAllSavedAddr(HttpServletRequest request) {
        SessionAttributes attributes = sessionService.getSessionAttributesFromRedis(getSessionId(request));
        if (attributes == null) {
            data = null;
            error = "请求参数错误";
            return retRes(ResponseCode.BADREQUEST, data, error);
        }
        List<CustomerAddr> customerAddrs = addrService.getAllAddr(attributes);
        data=customerAddrs;
        error=null;
        return retRes(ResponseCode.SUCCESS, data, error);
    }

    @RequestMapping("/setAddr")
    public ResponseUtils saveAddr(HttpServletRequest request, @RequestBody CustomerAddr web) {
        SessionAttributes attributes = sessionService.getSessionAttributesFromRedis(getSessionId(request));
        boolean flag = addrService.saveAddr(attributes, web);
        if (!flag){
            data = null;
            error = "服务器异常";
            return retRes(ResponseCode.SERVICE_ERROR, data, error);
        }
        data = true;
        error = null;
        return retRes(ResponseCode.SUCCESS, data, error);
    }

    public String getSessionId(HttpServletRequest request) {
        return request.getSession().getId();
    }

    private ResponseUtils retRes(ResponseCode code, Object data, String error) {
        return new ResponseUtils(code,data,error);
    }
}
