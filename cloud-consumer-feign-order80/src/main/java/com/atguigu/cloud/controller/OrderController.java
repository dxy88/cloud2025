package com.atguigu.cloud.controller;


import cn.hutool.core.date.DateUtil;
import com.atguigu.cloud.apis.PayFeignApi;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.resp.ReturnCodeEnum;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.swagger.v3.core.model.ApiDescription;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.element.NestingKind;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @Author: 邓晰洋
 * @CreateTime: 2025-09-29 15:52:15
 * @Description:
 * @Version: 1.0
 */
@Slf4j
@RestController
public class OrderController {
    @Resource
    private PayFeignApi payFeignApi;
    @PostMapping("/feign/add")
    public ResultData add(@RequestBody PayDTO payDTO){
        ResultData resultData = payFeignApi.add(payDTO);
        return resultData;
    }
    @DeleteMapping("/feign/delete/{id}")
    public ResultData delete(@PathVariable("id")Integer id){
        ResultData resultData = payFeignApi.delete(id);
        return resultData;
    }
    @GetMapping("/feign/get/info")
    public ResultData getInfo(){
        ResultData info=null;
        try{
            System.out.println(DateUtil.now());
            info = payFeignApi.getInfo();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(DateUtil.now());
            return ResultData.fail(ReturnCodeEnum.RC500.getCode(),ReturnCodeEnum.RC500.getMsg());
        }
        return info;
    }
//    @GetMapping("/feign/pay/circuit/{id}")
//    @CircuitBreaker(name="cloud-payment-service",fallbackMethod = "getFallback")
//    public String myCircuit(@PathVariable("id")Integer id){
//        String s = payFeignApi.myCircuit(id);
//        return s;
//    }

    @GetMapping("/feign/pay/bulkhead/{id}")
    @Bulkhead(name="cloud-payment-service",fallbackMethod = "getFallback",type = Bulkhead.Type.SEMAPHORE)
    public String myBulkhead(@PathVariable("id")Integer id){
        String s = payFeignApi.myBulkhead(id);
        return s;
    }
    public String getFallback(Integer id,Throwable e){
        log.info("当前异常id:{},异常原因{}",id,e.getMessage());
        return "当前服务异常，请稍后重试";
    }
//    public  String getFallback1(Exception e){
//        log.info("当前异常异常原因{}",e.getMessage());
//        return "当前服务异常,请稍后重试";
//    }
    @GetMapping("/feign/pay/pool/{id}")
    @Bulkhead(name="cloud-payment-service",fallbackMethod = "getPoolFallback",type= Bulkhead.Type.THREADPOOL)
    public CompletableFuture<String>myBulkheadPool(@PathVariable("id")Integer id){
        System.out.println("开启线程:"+Thread.currentThread().getName());
        CompletableFuture<String> stringCompletableFuture=null;
        try {
            TimeUnit.SECONDS.sleep(5);
          stringCompletableFuture= CompletableFuture.supplyAsync(() -> payFeignApi.myBulkhead(id));
            System.out.println("结束线程"+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return stringCompletableFuture;
    }
    public CompletableFuture<String>getPoolFallback(Integer id,Throwable e){
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> "当前服务异常，请稍后重试");
        return stringCompletableFuture;
    }
    @GetMapping("/feign/pay/rateLimiter/{id}")
    @RateLimiter(name="cloud-payment-service",fallbackMethod = "getFallback")
    public String myRateLimiter(@PathVariable("id")Integer id){
        String s = payFeignApi.myRateLimiter(id);
        return s;
    }
    @GetMapping("/feign/pay/micrometer/{id}")
    public String myMicrometer(@PathVariable("id")Integer id){
        String s = payFeignApi.myMicrometer(id);
        return s;
    }
}





























