package com.example.demo.service;

import com.example.demo.entity.Login;
import com.example.demo.jpa.LoginJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 创建信息
 * User:         ou
 * Date:         2019/6/24
 * Time:         0:06
 * Description : ********
 */
@Service("LoginService")
public class LoginService {
    @Autowired
    LoginJpa loginJpa;

    public Login findByWeChatId(String wechatid){
        return loginJpa.findByWeChatId(wechatid);
    }

    public Login findByLoginId(Integer loginid){
        return loginJpa.findByLoginId(loginid);
    }

    public Login addLogin(Login login){
        return loginJpa.save(login);
    }
}
