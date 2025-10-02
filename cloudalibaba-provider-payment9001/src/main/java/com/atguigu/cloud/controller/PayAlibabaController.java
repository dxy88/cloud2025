package com.atguigu.cloud.controller;


import cn.hutool.core.util.IdUtil;
import com.fasterxml.jackson.annotation.JsonGetter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 邓晰洋
 * @CreateTime: 2025-10-01 15:30:03
 * @Description:
 * @Version: 1.0
 */
@RestController
public class PayAlibabaController {
    @Value("${server.port}")
    private String port;
    @GetMapping("/pay/nacos/{id}")
    public String getById(@PathVariable("id") Integer id){

        return "当前id:"+id+"-"+"随机uuid:"+ IdUtil.simpleUUID()+"-"+"当前端口:"+port;
    }
}
