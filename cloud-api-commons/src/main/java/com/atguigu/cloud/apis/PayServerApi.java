package com.atguigu.cloud.apis;


import com.atguigu.cloud.fallback.ServerFallback;
import com.atguigu.cloud.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: 邓晰洋
 * @CreateTime: 2025-10-02 11:16:11
 * @Description:
 * @Version: 1.0
 */
@FeignClient(value="nacos-payment-provider",fallback = ServerFallback.class )
public interface PayServerApi {
    @GetMapping("/server/pay/get/{id}")
    ResultData serverByOrderNo(@PathVariable("id")Integer id);
}
