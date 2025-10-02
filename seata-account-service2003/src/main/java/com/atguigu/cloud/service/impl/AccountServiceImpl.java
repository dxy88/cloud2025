package com.atguigu.cloud.service.impl;


import com.atguigu.cloud.mapper.AccountMapper;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.service.AccountService;
import com.mysql.cj.util.TimeUtil;
import io.micrometer.core.instrument.util.TimeUtils;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author: 邓晰洋
 * @CreateTime: 2025-10-02 18:13:02
 * @Description:
 * @Version: 1.0
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountMapper accountMapper;
    @Override
    public void declareAccount(Long userId, Long money) throws InterruptedException {
        accountMapper.declareAccount(userId,money);
//        int i=1/0;
        timeout();
    }
    public void timeout() throws InterruptedException {
        TimeUnit.SECONDS.sleep(65);
    }
}
