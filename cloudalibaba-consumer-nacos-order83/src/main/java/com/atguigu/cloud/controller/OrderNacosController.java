package com.atguigu.cloud.controller;


import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: 邓晰洋
 * @CreateTime: 2025-10-01 15:53:50
 * @Description:
 * @Version: 1.0
 */
@RestController
@Slf4j
public class OrderNacosController {
    @Resource
    private RestTemplate restTemplate;
    @Value("${serverUrl.find}")
    private String path;
    @GetMapping("/consumer/pay/nacos/{id}")
    public String getById(@PathVariable("id")Integer id){
        return restTemplate.getForObject(path+"/pay/nacos/"+id,String.class);
    }
}
