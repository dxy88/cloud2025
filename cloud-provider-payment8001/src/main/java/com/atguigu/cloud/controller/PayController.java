package com.atguigu.cloud.controller;


import cn.hutool.core.bean.BeanUtil;

import cn.hutool.core.date.DateUtil;
import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author: 邓晰洋
 * @CreateTime: 2025-09-29 09:10:25
 * @Description:
 * @Version: 1.0
 */
@RestController
@Slf4j
@Tag(name="支付交易接口",description = "处理支付的模块")
public class PayController {
    @Resource
    private PayService payService;
    @PostMapping("/pay/add")
    @Operation(summary = "添加订单",description = "订单的增加功能")
    public ResultData add(@RequestBody PayDTO payDTO){
        Pay pay = BeanUtil.copyProperties(payDTO, Pay.class);
        int add = payService.add(pay);
        return ResultData.success("添加成功"+add);
    }
    @DeleteMapping("/pay/delete/{id}")
    public ResultData delete(@PathVariable("id")Integer id){
        int delete = payService.delete(id);
        return ResultData.success("删除成功"+delete);
    }
    @PutMapping("/pay/update")
    public ResultData update(@RequestBody PayDTO payDTO){
        int update = payService.update(payDTO);
        return ResultData.success("修改成功"+update);
    }
    @GetMapping("/pay/get/{id}")
    public ResultData getById(@PathVariable("id")Integer id){
        Pay pay = payService.getById(id);
        return ResultData.success(pay);
    }
    @GetMapping("/pay/get/all")
    public ResultData<List<Pay>> getAll(){
        List<Pay> payList = payService.getAll();
        return ResultData.success(payList);
    }
    @Value("${server.port}")
    private String port;
    @GetMapping("/pay/get/info")
    public ResultData getInfo(@Value("${com.atguigu}")String msg){
//        try{
//            TimeUnit.SECONDS.sleep(62);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        return ResultData.success("atguiguInfo:"+msg+" port:"+port);
    }
}













































































