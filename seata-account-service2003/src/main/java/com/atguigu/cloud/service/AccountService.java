package com.atguigu.cloud.service;


import com.atguigu.cloud.resp.ResultData;

/**
 * @Author: 邓晰洋
 * @CreateTime: 2025-10-02 18:12:47
 * @Description:
 * @Version: 1.0
 */

public interface AccountService {
    void declareAccount(Long userId, Long money) throws InterruptedException;
}
