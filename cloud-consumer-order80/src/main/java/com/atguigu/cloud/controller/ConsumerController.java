package com.atguigu.cloud.controller;


import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author: 邓晰洋
 * @CreateTime: 2025-09-29 10:48:54
 * @Description:
 * @Version: 1.0
 */
@RestController
@Slf4j
public class ConsumerController {
    @Resource
    private DiscoveryClient discoveryClient;
    @Resource
    private RestTemplate restTemplate;
    private static final String URL_PREFIX="http://cloud-payment-service";
    @PostMapping("/consumer/add")
    public ResultData add(@RequestBody PayDTO payDTO){
        ResultData resultData = restTemplate.postForObject(URL_PREFIX+"/pay/add", payDTO, ResultData.class);
        return resultData;
    }
    @DeleteMapping("/consumer/delete/{id}")
    public ResultData delete(@PathVariable("id")Integer id){
        ResponseEntity<ResultData> exchange = restTemplate.exchange(URL_PREFIX + "/pay/delete/{id}" ,
                HttpMethod.DELETE,null, ResultData.class,id);
        ResultData resultData = exchange.getBody();
        return resultData;
    }
    @PutMapping("/consumer/update")
    public ResultData update(@RequestBody PayDTO payDTO){
        ResponseEntity<ResultData> exchange = restTemplate.exchange(URL_PREFIX + "/pay/update", HttpMethod.PUT,
                new HttpEntity<>(payDTO), ResultData.class);
        ResultData resultData = exchange.getBody();
        return resultData;
    }
    @GetMapping("/consumer/get/{id}")
    public ResultData getById(@PathVariable("id")Integer id){
        ResultData resultData = restTemplate.getForObject(URL_PREFIX + "/pay/get/" + id, ResultData.class);
        return resultData;
    }
    @GetMapping("/consumer/get/all")
    public ResultData getAll(){
        ResultData resultData = restTemplate.getForObject(URL_PREFIX + "/pay/get/all", ResultData.class);
        return resultData;
    }
    @GetMapping("/consumer/get/info")
    public ResultData getInfo(){
        ResultData forObject = restTemplate.getForObject(URL_PREFIX + "/pay/get/info", ResultData.class);
        return forObject;
    }
    @GetMapping("/consumer/discovery")
    public String discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            System.out.println("当前服务为："+service);
        }
        System.out.println("=====================================================");
        System.out.println("=====================================================");
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getHost()+instance.getInstanceId()+":"+instance.getPort());
        }
        return "hello";
    }
}
