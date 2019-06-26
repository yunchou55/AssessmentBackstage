package com.example.demo.jpa;

import com.example.demo.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 创建信息
 * User:         ou
 * Date:         2019/6/23
 * Time:         23:45
 * Description : ********
 */
@Repository
public interface LoginJpa extends JpaRepository<Login,Integer> {
    //更据wechatid进行查询
    Login findByWeChatId(String wechatid);
    //更据userid进行查询
    Login findByLoginId(Integer loginid);
}
