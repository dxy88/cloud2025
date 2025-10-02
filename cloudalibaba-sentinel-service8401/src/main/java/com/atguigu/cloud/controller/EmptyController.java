package com.atguigu.cloud.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 邓晰洋
 * @CreateTime: 2025-10-02 09:48:16
 * @Description:
 * @Version: 1.0
 */
@RestController
public class EmptyController {
    @GetMapping("/empty")
    public String empty(){
        return "this is a empty object";
    }
}
