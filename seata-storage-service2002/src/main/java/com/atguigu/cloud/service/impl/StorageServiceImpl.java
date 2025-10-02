package com.atguigu.cloud.service.impl;


import com.atguigu.cloud.mapper.StorageMapper;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.service.StorageService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @Author: 邓晰洋
 * @CreateTime: 2025-10-02 17:20:50
 * @Description:
 * @Version: 1.0
 */
@Service
public class StorageServiceImpl implements StorageService {
    @Resource
    private StorageMapper storageMapper;
    @Override
    public void declareStorage(Long productId, Integer count) {
        storageMapper.declareStorage(productId,count);
    }
}
