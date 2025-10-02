package com.atguigu.cloud.controller;
import java.math.BigDecimal;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.resp.ReturnCodeEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 邓晰洋
 * @CreateTime: 2025-10-02 11:07:18
 * @Description:
 * @Version: 1.0
 */
@RestController
public class ServerController {
    @GetMapping("/server/pay/get/{id}")
    @SentinelResource(value="serverPay",blockHandler = "payBlockHandler")
    public ResultData serverByOrderNo(@PathVariable("id")Integer id){
        PayDTO payDTO=new PayDTO();
        payDTO.setId(id);
        payDTO.setPayNo("xxx");
        payDTO.setOrderNo("yyy");
        payDTO.setUserId(1);
        payDTO.setAmount(new BigDecimal("22.2"));
        return ResultData.success(payDTO);
    }
    public ResultData payBlockHandler(Integer id, BlockException blockException){
//        System.out.println("==============="+id);
        return ResultData.fail(ReturnCodeEnum.RC500.getCode(), "当前服务器繁忙,请稍后重试，重试id:"+id);
    }
}

































