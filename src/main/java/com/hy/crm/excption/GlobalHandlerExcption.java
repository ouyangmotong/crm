package com.hy.crm.excption;

import com.hy.crm.utils.MsgTool;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.naming.AuthenticationException;

/**
 * @author kw
 * @version 1.0
 * @description异常增强类
 * @date 2020/9/1 9:27 星期二
 */

@ControllerAdvice
public class GlobalHandlerExcption {
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(AuthenticationException.class)
    @ResponseBody
    public MsgTool doGetAuthenticationException(AuthenticationException ex){
        //创建信息对象
        MsgTool  ms=new MsgTool();
        ms.setCode(400);
        ms.setMsg(ex.getMessage());
        return ms;

    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    @ResponseBody
    public MsgTool deGetDafaultExcption(Exception ex){
        MsgTool ms=new MsgTool();
        ms.setCode(500);
        ms.setMsg("未知错误"+ex.getMessage());
        ms.setData("");
        return ms;

    }
}
