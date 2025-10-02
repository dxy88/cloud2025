package com.atguigu.cloud.apis;


import com.atguigu.cloud.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: 邓晰洋
 * @CreateTime: 2025-09-30 15:53:26
 * @Description:
 * @Version: 1.0
 */
@FeignClient("cloud-gateway")
public interface PayGatewayApi {
    @GetMapping("/pay/gateway/get/{id}")
    ResultData getById(@PathVariable("id")Integer id);
    @GetMapping("/pay/gateway/getInfo")
    ResultData getInfo();
}
