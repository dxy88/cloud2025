package com.atguigu.cloud.controller;


import cn.hutool.core.util.IdUtil;
import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.service.PayService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Enumeration;
import java.util.HashMap;

/**
 * @Author: 邓晰洋
 * @CreateTime: 2025-09-30 15:50:27
 * @Description:
 * @Version: 1.0
 */
@RestController
public class PayGatewayController {
    @Resource
    private PayService payService;
    @GetMapping("/pay/gateway/get/{id}")
    public ResultData getById(@PathVariable("id")Integer id){
        Pay pay = payService.getById(id);
        return ResultData.success(pay);
    }
    @GetMapping("/pay/gateway/getInfo")
    public ResultData getInfo(){
        return ResultData.success("当前随机id："+IdUtil.randomUUID());
    }
    @GetMapping("/pay/gateway/filter")
    public ResultData getRequestHeader(HttpServletRequest request){
        Enumeration<String> headerNames = request.getHeaderNames();
        String result="";
        while (headerNames.hasMoreElements()){
            String name= headerNames.nextElement();
            String value = request.getHeader(name);
            System.out.println(name+"=\t"+value);
            if(name.equalsIgnoreCase("X-Request-atguigu1")||name.equalsIgnoreCase("X-request-atguigu2")){
                result+=name+"=\t"+value;
            }
        }
//        String header = request.getParameter("consumerId");
//        System.out.println("last:"+header);
//        String header1 = request.getParameter("consumerName");
//        System.out.println("last:"+header1);
        return ResultData.success("邓晰洋"+result);
    }
}
