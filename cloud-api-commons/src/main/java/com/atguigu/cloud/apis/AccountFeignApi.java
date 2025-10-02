package com.atguigu.cloud.apis;


import com.atguigu.cloud.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: 邓晰洋
 * @CreateTime: 2025-10-02 16:19:32
 * @Description:
 * @Version: 1.0
 */
@FeignClient("seata-account-service")
public interface AccountFeignApi {
    @PostMapping("/account/decrease")
    ResultData declareAccount(@RequestParam("userId")Long userId,
                              @RequestParam("money")Long money);
}
