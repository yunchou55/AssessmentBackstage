package com.example.demo.service;

import com.example.demo.entity.EntrustNoNecessary;
import com.example.demo.jpa.EntrustNoNecessaryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 创建信息
 * User:         ou
 * Date:         2019/6/25
 * Time:         17:23
 * Description : ********
 */
@Service("EntrustNoNecessaryService")
public class EntrustNoNecessaryService {

    @Autowired
    EntrustNoNecessaryJpa entrustNoNecessaryJpa;

    public EntrustNoNecessary addEntrustNecessary(EntrustNoNecessary entrustNoNecessary){
        return entrustNoNecessaryJpa.save(entrustNoNecessary);
    }

    public EntrustNoNecessary findEntrustNecessary(Integer noNecessaryId){
        return entrustNoNecessaryJpa.findByNoNecessaryId(noNecessaryId);
    }
}
