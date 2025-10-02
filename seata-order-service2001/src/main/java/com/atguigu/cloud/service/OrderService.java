package com.atguigu.cloud.service;


import com.atguigu.cloud.entities.Order;
import com.atguigu.cloud.resp.ResultData;

/**
 * @Author: 邓晰洋
 * @CreateTime: 2025-10-02 16:33:13
 * @Description:
 * @Version: 1.0
 */

public interface OrderService {
    ResultData create(Order order);
}
