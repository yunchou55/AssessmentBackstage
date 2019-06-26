package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.jpa.UserJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 创建信息
 * User:         ou
 * Date:         2019/6/23
 * Time:         19:55
 * Description : ********
 */
@Service("UserService")
public class UserService {
    @Autowired
    UserJpa userJpa;

    public User findByUserId(Integer Id){
        return userJpa.findById(Id).get();
    }

    public User findByLoginId(Integer loginid){
        return userJpa.findByLoginId(loginid);
    }

    public User addUser(User user){
        return userJpa.save(user);
    }
}
