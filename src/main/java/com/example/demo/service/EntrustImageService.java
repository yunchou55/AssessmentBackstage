package com.example.demo.service;

import com.example.demo.entity.EntrustImage;
import com.example.demo.jpa.EntrustImageJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 创建信息
 * User:         ou
 * Date:         2019/6/26
 * Time:         11:07
 * Description : ********
 */
@Service("EntrustImageService")
public class EntrustImageService {

    @Autowired
    EntrustImageJpa entrustImageJpa;

    public EntrustImage addEntrustImage(EntrustImage entrustImage){
        return entrustImageJpa.save(entrustImage);
    }

    public List<EntrustImage> findByEntrustId(Integer entrustId){
        return entrustImageJpa.findByEntrustId(entrustId);
    }

    public Integer deleteByEntrustImageId(Integer entrustImageId){
        return entrustImageJpa.deleteByEntrustImageId(entrustImageId);
    }
}
