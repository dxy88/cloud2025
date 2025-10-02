package com.atguigu.cloud.controller;


import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.service.StorageService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 邓晰洋
 * @CreateTime: 2025-10-02 17:17:39
 * @Description:
 * @Version: 1.0
 */
@RestController
public class StorageController {
    @Resource
    private StorageService storageService;
    @PostMapping("/storage/decrease")
    public ResultData declareStorage(@RequestParam("productId")Long productId,
                                     @RequestParam("count")Integer count){
        storageService.declareStorage(productId,count);
        return ResultData.success("修改成功");
    }
}
