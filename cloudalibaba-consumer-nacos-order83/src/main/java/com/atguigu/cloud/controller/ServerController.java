package com.atguigu.cloud.controller;


import com.atguigu.cloud.apis.PayServerApi;
import com.atguigu.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.aopalliance.intercept.Interceptor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 邓晰洋
 * @CreateTime: 2025-10-02 11:22:11
 * @Description:
 * @Version: 1.0
 */
@RestController
public class ServerController {
    @Resource
    private PayServerApi payServerApi;
    @GetMapping("/consumer/server/pay/get/{id}")
    public ResultData serverByOrderNo(@PathVariable("id")Integer id){
        ResultData resultData = payServerApi.serverByOrderNo(id);
        return resultData;
    }
}
