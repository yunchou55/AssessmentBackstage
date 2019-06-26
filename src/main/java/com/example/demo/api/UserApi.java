package com.example.demo.api;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

/**
 * 创建信息
 * User:         ou
 * Date:         2019/6/24
 * Time:         15:05
 * Description : ********
 */
@RestController
@RequestMapping("User")
public class UserApi {
    private static final Logger LOG = LoggerFactory.getLogger(UserApi.class);

    @Autowired
    UserService userService;

    @ApiOperation(value = "添加或修改User信息",notes = "新增或修改User")
    @ApiImplicitParam(name = "user",value = "增加user信息",required = true,dataType = "User")
    @PostMapping(value = "addUser")
    public Object addUser(@RequestBody User user){
        JSONObject jsonObject = new JSONObject();
        User addUser = null;
        try {
            addUser = userService.addUser(user);
        } catch (Exception e) {
            LOG.error("添加user信息出错！");
            jsonObject.put("message","无法添加！");
            return jsonObject;
        }
        jsonObject.put("message","添加成功！");
        jsonObject.put("userInfo",addUser);
        return jsonObject;
    }



    @ApiOperation(value = "查询User信息",notes = "根据loginid")
    @ApiImplicitParam(name = "loginid",value = "查询用户信息实体user",required = true,dataType = "Integer")
    @GetMapping(value = "/FindUserByLoginId/{loginid}")
    public Object findUserByLoginId(@PathVariable(name = "loginid") Integer loginid){
        JSONObject jsonObject = new JSONObject();
        User findUser = null;
        try {
            findUser = userService.findByLoginId(loginid);
        } catch (Exception e) {
            jsonObject.put("message","查询出错!");
            e.printStackTrace();
            return jsonObject;
        }
        if (findUser==null){
            jsonObject.put("message","查无此用户");
            return jsonObject;
        }
        jsonObject.put("mesesage","查询成功!");
        jsonObject.put("userInfo",findUser);
        return jsonObject;
    }

}
