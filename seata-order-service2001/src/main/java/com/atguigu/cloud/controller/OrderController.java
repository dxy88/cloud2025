package com.atguigu.cloud.controller;


import com.atguigu.cloud.entities.Order;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.service.OrderService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 邓晰洋
 * @CreateTime: 2025-10-02 16:32:01
 * @Description:
 * @Version: 1.0
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;
    @GetMapping("/order/create")
    public ResultData create(Order order){
        return orderService.create(order);
    }
}
