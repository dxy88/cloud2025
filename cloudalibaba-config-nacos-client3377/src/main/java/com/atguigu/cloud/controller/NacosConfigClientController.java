package com.atguigu.cloud.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 邓晰洋
 * @CreateTime: 2025-10-01 16:40:06
 * @Description:
 * @Version: 1.0
 */
@RestController
@Slf4j
@RefreshScope
public class NacosConfigClientController {
    @Value("${my.config}")
    private String config;
    @GetMapping("/config/info")
    public String getInfo(){
        return "当前配置信息"+config;
    }
}
