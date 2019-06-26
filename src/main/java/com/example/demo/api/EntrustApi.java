package com.example.demo.api;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Entrust;
import com.example.demo.entity.EntrustAddress;
import com.example.demo.entity.EntrustNecessary;
import com.example.demo.entity.EntrustNoNecessary;
import com.example.demo.jpa.EntrustJpa;
import com.example.demo.jpa.EntrustNecessaryJpa;
import com.example.demo.jpa.EntrustNoNecessaryJpa;
import com.example.demo.service.EntrustAddressService;
import com.example.demo.service.EntrustNecessaryService;
import com.example.demo.service.EntrustNoNecessaryService;
import com.example.demo.service.EntrustService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 创建信息
 * User:         ou
 * Date:         2019/6/25
 * Time:         17:26
 * Description : ********
 */
@RestController
@RequestMapping("Entrust")
public class EntrustApi {
    private static final Logger LOG = LoggerFactory.getLogger(LoginApi.class);


    @Autowired
    EntrustService entrustService;

    @Autowired
    EntrustNecessaryService entrustNecessaryService;

    @Autowired
    EntrustNoNecessaryService entrustNoNecessaryService;

    @Autowired
    EntrustAddressService entrustAddressService;

    @ApiOperation(value = "添加/修改Entrust",notes = "根据Entrust信息传入")
    @ApiImplicitParam(name = "entrust",value = "若添加，把necessaryId与noNecessaryId设置为0，若修改，需要传入entrustId值",dataType = "Entrust",required = true)
    @PostMapping(value = "/AddEntrust")
    public Object addEntrust(@RequestBody Entrust entrust){
        JSONObject jsonObject = new JSONObject();
        Entrust addentrust = null;
        try {
            addentrust = entrustService.addEntrust(entrust);
        } catch (Exception e) {
            LOG.error("添加entrust出错！");
            jsonObject.put("message","添加任务失败!");
            return jsonObject;
        }
        jsonObject.put("entrustInfo",entrust);
        jsonObject.put("message","添加任务成功!");
        return jsonObject;
    }


    @ApiOperation(value = "添加EntrustNecessary",notes = "根据传入的任务必要对象")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "entrustId", value = "复合表任务id", dataType = "Integer", required = true, paramType = "path"),
            @ApiImplicitParam(name = "entrustNecessary", value = "添加必要任务信息", required = true, dataType = "EntrustNecessary"),
    })
    @PostMapping(value = "/AddEntrustNecessary/{entrustId}")
    public Object addentrustnecessary(@PathVariable(value = "entrustId") Integer entrustId,@RequestBody EntrustNecessary entrustNecessary){
        JSONObject jsonObject = new JSONObject();
        EntrustNecessary addentrustNecessary = null;
        Integer entrustNecessaryId = 0;
        try {
            addentrustNecessary= entrustNecessaryService.addEntrustNecessary(entrustNecessary);
            entrustNecessaryId = addentrustNecessary.getNecessaryId();
            Entrust updateentrust = entrustService.findByEntrustId(entrustId);
            updateentrust.setNecessaryId(entrustNecessaryId);
            entrustService.addEntrust(updateentrust);
        } catch (Exception e) {
            LOG.error("保存必要任务信息出错!");
            jsonObject.put("message","保存必要任务信息出错!");
            return jsonObject;
        }
        jsonObject.put("entrustNecessaryId",entrustNecessaryId);
        jsonObject.put("message","保存必要任务信息成功!");
        return jsonObject;
    }

    @ApiOperation(value = "修改EntrustNecessary",notes = "根据传入的任务必要对象")
    @ApiImplicitParams(@ApiImplicitParam(name = "entrustNecessary", value = "添加登录信息实体login", required = true, dataType = "EntrustNecessary"))
    @PostMapping(value = "/UpdateEntrustNecessary")
    public Object updateentrustnecessary(@RequestBody EntrustNecessary entrustNecessary){
        JSONObject jsonObject = new JSONObject();
        EntrustNecessary updateentrustNecessary = null;
        try {
            updateentrustNecessary = entrustNecessaryService.addEntrustNecessary(entrustNecessary);
        } catch (Exception e) {
            LOG.error("修改必要任务信息出错!");
            jsonObject.put("mesasge","修改必要任务信息失败!");
            return jsonObject;
        }
        jsonObject.put("message","修改成功!");
        jsonObject.put("entrustNecessaryId",updateentrustNecessary.getNecessaryId());
        return jsonObject;
    }

    @ApiOperation(value = "添加EntrustNoNecessary",notes = "根据传入的任务不必要对象")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "entrustId", value = "复合表任务id", dataType = "Integer", required = true, paramType = "path"),
            @ApiImplicitParam(name = "entrustNoNecessary", value = "添加不必要任务信息", required = true, dataType = "EntrustNoNecessary"),
    })
    @PostMapping(value = "/AddEntrustNoNecessary/{entrustId}")
    public Object addentrustnonecessary(@PathVariable(value = "entrustId") Integer entrustId,@RequestBody EntrustNoNecessary entrustNoNecessary){
        JSONObject jsonObject = new JSONObject();
        EntrustNoNecessary addentrustNoNecessary = null;
        Integer entrustNoNecessaryId = 0;
        try {
            addentrustNoNecessary= entrustNoNecessaryService.addEntrustNecessary(entrustNoNecessary);
            entrustNoNecessaryId = addentrustNoNecessary.getNoNecessaryId();
            Entrust updateentrust = entrustService.findByEntrustId(entrustId);
            updateentrust.setNoNecessaryId(entrustNoNecessaryId);
            entrustService.addEntrust(updateentrust);
        } catch (Exception e) {
            LOG.error("保存不必要任务信息出错!");
            jsonObject.put("message","保存不必要任务信息出错!");
            return jsonObject;
        }
        jsonObject.put("entrustNoNecessaryId",entrustNoNecessaryId);
        jsonObject.put("message","保存必要任务信息成功!");
        return jsonObject;
    }

    @ApiOperation(value = "修改NoEntrustNoNecessary",notes = "根据传入的不任务必要对象")
    @ApiImplicitParam(name = "entrustNoNecessary", value = "添加不必要任务信息实体EntrustNoNecessary", required = true, dataType = "EntrustNoNecessary")
    @PostMapping(value = "/UpdateNoEntrustNecessary")
    public Object updateentrustnonecessary(@RequestBody EntrustNoNecessary entrustNoNecessary){
        JSONObject jsonObject = new JSONObject();
        EntrustNoNecessary updateentrustNoNecessary = null;
        try {
            updateentrustNoNecessary = entrustNoNecessaryService.addEntrustNecessary(entrustNoNecessary);
        } catch (Exception e) {
            LOG.error("修改不必要任务信息出错!");
            jsonObject.put("mesasge","修改不必要任务信息失败!");
            return jsonObject;
        }
        jsonObject.put("message","修改成功!");
        jsonObject.put("entrustNecessaryId",updateentrustNoNecessary.getNoNecessaryId());
        return jsonObject;
    }


    @ApiOperation(value = "添加/修改EntrustAddress",notes = "根据传入的地址对象")
    @ApiImplicitParam(name = "entrustaddress", value = "添加/修改地址信息实体", required = true, dataType = "EntrustAddress")
    @PostMapping(value = "/AddEntrustAddress")
    public Object addentrustaddress(@RequestBody EntrustAddress entrustAddress){
        JSONObject jsonObject = new JSONObject();
        EntrustAddress addentrustaddress = null;
        try {
            addentrustaddress = entrustAddressService.addEntrustAddress(entrustAddress);
        } catch (Exception e) {
            LOG.error("添加/修改地址对象失败");
            jsonObject.put("message","添加/修改地址对象失败!");
            return jsonObject;
        }
        jsonObject.put("entrustaddressId",addentrustaddress.getEntrustAddressId());
        jsonObject.put("message","添加/修改地址对象成功!");
        return jsonObject;
    }

    @ApiOperation(value = "查看EntrustAddress",notes = "根据传入的任务Id进行查询")
    @ApiImplicitParam(name = "entrustId", value = "查询该任务的所有地址对象", required = true, dataType = "Integer",paramType = "entrustId")
    @PostMapping(value = "/findEntrustAddress/{entrustId}")
    public Object findentrustaddress(@PathVariable(value = "entrustId") Integer entrustId){
        JSONObject jsonObject = new JSONObject();
        List<EntrustAddress> findentrustaddress = null;
        try {
            findentrustaddress = entrustAddressService.findByEntrustId(entrustId);
        } catch (Exception e) {
            LOG.error("查询任务地址出错!");
            jsonObject.put("message","查询任务地址出错！");
            return jsonObject;
        }
        jsonObject.put("entrustaddressInfo",findentrustaddress);
        jsonObject.put("message","查询任务f地址对象成功!");
        return jsonObject;
    }

    @ApiOperation(value = "删除EntrustAddress",notes = "根据传入的任务地址对象Id")
    @ApiImplicitParam(name = "entrustaddressid", value = "任务的地址对象Id", required = true, dataType = "Integer",paramType = "entrustaddressid")
    @PostMapping(value = "/deleteEntrustAddress/{entrustaddressid}")
    public Object deleteentrustaddress(@PathVariable(value = "entrustaddressid") Integer entrustaddressid){
        JSONObject jsonObject = new JSONObject();
        Integer deleteentrustAddressId = null;
        try {
            deleteentrustAddressId = entrustAddressService.deleteByEntrustAddressId(entrustaddressid);
        } catch (Exception e) {
            LOG.error("删除任务地址对象出错！");
            jsonObject.put("message","删除任务地址对象出错!");
            return jsonObject;
        }
        jsonObject.put("deleteentrustaddressId",deleteentrustAddressId);
        jsonObject.put("message","删除任务地址对象成功!");
        return jsonObject;
    }

//    @ApiOperation(value = "保存EntrustImage",notes = "保存任务图片EntrustImage")
}
