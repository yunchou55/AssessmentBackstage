package com.example.demo.interceptor;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 创建信息
 * User:         ou
 * Date:         2019/6/23
 * Time:         19:45
 * Description : ********
 */
@ControllerAdvice
public class GloablExceptionHandler {
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Object handleException(Exception e){
        String msg = e.getMessage();
        if (msg == null || msg.equals("")){
            msg = "服务器出错";
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message",msg);
        return jsonObject;
    }
}
