package com.atguigu.cloud.service;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 * @Author: 邓晰洋
 * @CreateTime: 2025-10-01 19:25:07
 * @Description:
 * @Version: 1.0
 */
@Service
public class FlowLimiterService {
    @SentinelResource(value="common")
    public void flowCommon(){
        System.out.println("common come in...");
    }
}
