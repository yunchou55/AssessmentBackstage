package com.example.demo.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.demo.entity.Login;
import com.example.demo.entity.User;
import org.springframework.stereotype.Service;

/**
 * 创建信息
 * User:         ou
 * Date:         2019/6/23
 * Time:         20:00
 * Description : ********
 */
@Service("TokenService")
public class TokenService {
    public String getToken(Login login){
        String token = "";
        token = JWT.create().withAudience(String.valueOf(login.getLoginId())).sign(Algorithm.HMAC256(login.getCpuId()+login.getFingerId()));
        return token;
    }
}
