package com.atguigu.cloud.service;


import com.atguigu.cloud.resp.ResultData;

/**
 * @Author: 邓晰洋
 * @CreateTime: 2025-10-02 17:20:33
 * @Description:
 * @Version: 1.0
 */

public interface StorageService {
    void declareStorage(Long productId, Integer count);
}
