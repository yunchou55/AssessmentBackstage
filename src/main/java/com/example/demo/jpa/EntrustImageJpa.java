package com.example.demo.jpa;

import com.example.demo.entity.EntrustImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 创建信息
 * User:         ou
 * Date:         2019/6/26
 * Time:         9:29
 * Description : ********
 */
@Repository
public interface EntrustImageJpa extends JpaRepository<EntrustImage,Integer> {
    @Transactional
    Integer deleteByEntrustImageId(Integer entrustImageId);

    List<EntrustImage> findByEntrustId(Integer entrustId);
}
