package com.atguigu.cloud.apis;


import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: 邓晰洋
 * @CreateTime: 2025-09-29 15:49:25
 * @Description:
 * @Version: 1.0
 */
@FeignClient("cloud-payment-service")
public interface PayFeignApi {
    @PostMapping("/pay/add")
    ResultData add(@RequestBody PayDTO payDTO);
    @DeleteMapping("/pay/delete/{id}")
    ResultData delete(@PathVariable("id")Integer id);
    @GetMapping("/pay/get/info")
    ResultData getInfo();
    @GetMapping("/pay/circuit/{id}")
    String myCircuit(@PathVariable("id")Integer id);
    @GetMapping("/pay/bulkhead/{id}")
    String myBulkhead(@PathVariable("id")Integer id);
    @GetMapping("/pay/rateLimit/{id}")
    String myRateLimiter(@PathVariable("id")Integer id);
    @GetMapping("/pay/micrometer/{id}")
    String myMicrometer(@PathVariable("id")Integer id);


}
