package com.example.demo.jpa;

import com.example.demo.entity.EntrustNoNecessary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 创建信息
 * User:         ou
 * Date:         2019/6/24
 * Time:         23:49
 * Description : ********
 */
@Repository
public interface EntrustNoNecessaryJpa extends JpaRepository<EntrustNoNecessary,Integer>{
    EntrustNoNecessary findByNoNecessaryId(Integer noNecessaryId);
}
