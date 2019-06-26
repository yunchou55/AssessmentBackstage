package com.example.demo.jpa;

import com.example.demo.entity.EntrustNecessary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 创建信息
 * User:         ou
 * Date:         2019/6/24
 * Time:         23:39
 * Description : ********
 */
@Repository
public interface EntrustNecessaryJpa extends JpaRepository<EntrustNecessary,Integer> {
    EntrustNecessary findByNecessaryId(Integer necessaryId);
}
