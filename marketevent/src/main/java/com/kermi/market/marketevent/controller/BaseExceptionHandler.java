package com.kermi.market.marketevent.controller;
import com.kermi.market.marketevent.entity.StatusCode;
import com.kermi.market.marketevent.entity.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Result exception(Exception e){
        e.printStackTrace();
        return  new Result(false, StatusCode.ERROR,e.getMessage());
    }
}
