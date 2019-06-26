package com.example.demo.jpa;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * 创建信息
 * User:         ou
 * Date:         2019/6/23
 * Time:         19:53
 * Description : ********
 */
@Repository
public interface UserJpa extends JpaRepository<User,Integer> {
    //更据userid进行查询
    User findByUserId(Integer userid);
    User findByLoginId(Integer loginid);
}
