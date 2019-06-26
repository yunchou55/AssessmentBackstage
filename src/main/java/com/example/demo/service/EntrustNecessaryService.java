package com.example.demo.service;

import com.example.demo.entity.EntrustNecessary;
import com.example.demo.jpa.EntrustNecessaryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 创建信息
 * User:         ou
 * Date:         2019/6/24
 * Time:         23:43
 * Description : ********
 */
@Service("EntrustNecessaryService")
public class EntrustNecessaryService {
    @Autowired
    EntrustNecessaryJpa entrustNecessaryJpa;

    public EntrustNecessary addEntrustNecessary(EntrustNecessary entrustNecessary){
        return entrustNecessaryJpa.save(entrustNecessary);
    }

    public EntrustNecessary findEntrustNecessary(Integer necessaryId){
        return entrustNecessaryJpa.findByNecessaryId(necessaryId);
    }
}
