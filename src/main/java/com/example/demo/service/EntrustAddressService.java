package com.example.demo.service;

import com.example.demo.entity.EntrustAddress;
import com.example.demo.jpa.EntrustAddressJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 创建信息
 * User:         ou
 * Date:         2019/6/25
 * Time:         22:08
 * Description : ********
 */
@Service("EntrustAddressService")
public class EntrustAddressService {

    @Autowired
    EntrustAddressJpa entrustAddressJpa;

    public List<EntrustAddress> findByEntrustId(Integer entrustId){
        return entrustAddressJpa.findByEntrustId(entrustId);
    }

    public EntrustAddress addEntrustAddress(EntrustAddress entrustAddress){
        return entrustAddressJpa.save(entrustAddress);
    }

    public Integer deleteByEntrustAddressId(Integer entrustAddressId){
        return entrustAddressJpa.deleteByEntrustAddressId(entrustAddressId);
    }

}
