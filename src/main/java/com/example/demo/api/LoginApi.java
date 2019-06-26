package com.example.demo.api;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.annotation.UserLoginToken;
import com.example.demo.entity.Login;
import com.example.demo.entity.User;
import com.example.demo.service.LoginService;
import com.example.demo.service.TokenService;
import com.example.demo.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 创建信息
 * User:         ou
 * Date:         2019/6/23
 * Time:         20:12
 * Description : ********
 */
@RestController
@RequestMapping("Login")
public class LoginApi {
    private static final Logger LOG = LoggerFactory.getLogger(LoginApi.class);

    @Autowired
    LoginService loginService;

    @Autowired
    TokenService tokenService;

    @ApiOperation(value = "添加Login",notes = "根据传入的login对象")
    @ApiImplicitParam(name = "login",value = "添加登录信息实体login",required = true,dataType = "Login")
    @PostMapping(value = "/AddLogin")
    public Object addlogin(@RequestBody Login login){
        JSONObject jsonObject = new JSONObject();
        Login addlogin=null;
        try {
            addlogin = loginService.addLogin(login);
        } catch (Exception e) {
            LOG.error("添加Login信息出错！");
            jsonObject.put("message","用户添加失败!");
            return jsonObject;
        }
        String token = tokenService.getToken(login);
        jsonObject.put("message","用户添加成功!");
        jsonObject.put("loginId",addlogin.getLoginId());
        jsonObject.put("token",token);
        return jsonObject;
    }

    @ApiOperation(value = "查询Login",notes = "根据user_id")
    @ApiImplicitParam(name = "login",value = "登录信息实体login",required = true,dataType = "Login")
    @PostMapping(value = "/FindLogin")
    public Object findlogin(@RequestBody Login login){
        JSONObject jsonObject = new JSONObject();
        Login loginForBase = loginService.findByWeChatId(login.getWeChatId());
        if (loginForBase==null){
            jsonObject.put("message","登录失败，用户不存在！");
            return jsonObject;
        }
        else {
            if (loginForBase.getCpuId().equals(login.getCpuId())&&loginForBase.getFingerId().equals(login.getFingerId())){
                String token = tokenService.getToken(loginForBase);
                jsonObject.put("token",token);
                jsonObject.put("logininfo",loginForBase);
                return jsonObject;
            }
            else {
                jsonObject.put("message","登录失败，微信与指纹不符合！");
                return jsonObject;
            }
        }
    }
    @UserLoginToken
    @GetMapping("/geMessage")
    public String getMessage(){
        return "你已经通过验证";
    }
}

