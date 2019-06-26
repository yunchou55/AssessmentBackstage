package com.example.demo.service;

import com.example.demo.entity.Entrust;
import com.example.demo.jpa.EntrustJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 创建信息
 * User:         ou
 * Date:         2019/6/24
 * Time:         23:28
 * Description : ********
 */
@Service("EntrustService")
public class EntrustService {
    @Autowired
    EntrustJpa entrustJpa;

    public Entrust addEntrust(Entrust entrust){
        return entrustJpa.save(entrust);
    }

    public Entrust findByEntrustId(Integer entrustid){
        return entrustJpa.findByEntrustId(entrustid);
    }

    public Integer deletByEntrustId(Integer entrustid){
        return entrustJpa.deleteByEntrustId(entrustid);
    }


}
