package com.atguigu.cloud.controller;


import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import java.util.concurrent.TimeUnit;

/**
 * @Author: 邓晰洋
 * @CreateTime: 2025-09-29 19:30:31
 * @Description:
 * @Version: 1.0
 */
@Slf4j
@RestController
public class PayCircuitController {
    @GetMapping("/pay/circuit/{id}")
    public String myCircuit(@PathVariable("id")Integer id){
        if(id.equals(-1)){
            throw new RuntimeException();
        }else if(id.equals(999)){
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "请求成功当前id为:"+id+",当前的uuid为："+ IdUtil.simpleUUID();
    }
    @GetMapping("/pay/bulkhead/{id}")
    public String myBulkhead(@PathVariable("id")Integer id){
        if(id.equals(-1)){
            throw new RuntimeException();
        }else if(id.equals(999)){
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "请求成功当前id为:"+id+",当前的uuid为："+ IdUtil.simpleUUID();
    }
    @GetMapping("/pay/rateLimit/{id}")
    public String myRateLimiter(@PathVariable("id")Integer id){
        return "请求成功，当前线程随机id:"+IdUtil.simpleUUID();
    }
    @GetMapping("/pay/micrometer/{id}")
    public String myMicrometer(@PathVariable("id")Integer id){
        return "请求成功，当前id:"+id+"-"+"当前随机id:"+IdUtil.simpleUUID();
    }
}
