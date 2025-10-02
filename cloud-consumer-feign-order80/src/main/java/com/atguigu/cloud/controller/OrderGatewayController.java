package com.atguigu.cloud.controller;


import com.atguigu.cloud.apis.PayGatewayApi;
import com.atguigu.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 邓晰洋
 * @CreateTime: 2025-09-30 15:55:14
 * @Description:
 * @Version: 1.0
 */
@RestController
public class OrderGatewayController {
    @Resource
    private PayGatewayApi payGatewayApi;
    @GetMapping("/feign/pay/gateway/get/{id}")
    public ResultData getById(@PathVariable("id")Integer id){
        ResultData resultData= payGatewayApi.getById(id);
        return resultData;
    }
    @GetMapping("/feign/pay/gateway/getInfo")
    public ResultData getInfo(){
        ResultData info = payGatewayApi.getInfo();
        return info;
    }
}
