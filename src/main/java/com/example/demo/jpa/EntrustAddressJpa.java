package com.example.demo.jpa;

import com.example.demo.entity.EntrustAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 创建信息
 * User:         ou
 * Date:         2019/6/25
 * Time:         22:05
 * Description : ********
 */
@Repository
public interface EntrustAddressJpa extends JpaRepository<EntrustAddress,Integer>{
    @Transactional
    Integer deleteByEntrustAddressId(Integer entrustaddressId);

    List<EntrustAddress> findByEntrustId(Integer entrustId);
}
