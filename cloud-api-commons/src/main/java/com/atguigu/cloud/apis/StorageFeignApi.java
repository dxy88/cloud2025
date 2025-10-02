package com.atguigu.cloud.apis;


import com.atguigu.cloud.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: 邓晰洋
 * @CreateTime: 2025-10-02 16:12:32
 * @Description:
 * @Version: 1.0
 */
@FeignClient("seata-storage-service")
public interface StorageFeignApi {
    @PostMapping("/storage/decrease")
    public ResultData declareStorage(@RequestParam("productId")Long productId,
                                     @RequestParam("count")Integer count);

}
