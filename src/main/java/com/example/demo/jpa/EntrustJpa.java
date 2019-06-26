package com.example.demo.jpa;

import com.example.demo.entity.Entrust;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 * 创建信息
 * User:         ou
 * Date:         2019/6/24
 * Time:         23:18
 * Description : ********
 */
@Repository
public interface EntrustJpa extends JpaRepository<Entrust,Integer> {
    Entrust findByEntrustId(Integer entrustid);

    @Transactional
    Integer deleteByEntrustId(Integer entrustid);
}
