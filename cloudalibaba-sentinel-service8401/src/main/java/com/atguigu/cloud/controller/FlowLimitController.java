package com.atguigu.cloud.controller;


import cn.hutool.core.date.DateUtil;
import cn.hutool.core.thread.ThreadUtil;
import com.alibaba.csp.sentinel.util.TimeUtil;
import com.atguigu.cloud.service.FlowLimiterService;
import io.micrometer.core.instrument.util.TimeUtils;
import jakarta.annotation.Resource;
import org.apache.http.client.utils.DateUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Author: 邓晰洋
 * @CreateTime: 2025-10-01 18:43:57
 * @Description:
 * @Version: 1.0
 */
@RestController
public class FlowLimitController {
    @GetMapping("/limitA")
    public String limitA(){
        return "limitA...";
    }
    @GetMapping("/limitB")
    public String limitB(){
        return "limitB...";
    }
    @Resource
    private FlowLimiterService flowLimiterService;
    @GetMapping("/limitC")
    public String limitC(){
        flowLimiterService.flowCommon();
        return "limitC...";
    }
    @GetMapping("/limitD")
    public String limitD(){
        flowLimiterService.flowCommon();
        return "limitD...";
    }
    @GetMapping("/limitE")
    public String limitE(){
        System.out.println("time"+System.currentTimeMillis()+"....");
        return "ok..limitE";
    }
    @GetMapping("/limitF")
    public String limitF() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        return "limitF...";
    }
    @GetMapping("/limitG")
    public String limitG(){
        int i=1/0;
        return "limitG...";
    }
}
