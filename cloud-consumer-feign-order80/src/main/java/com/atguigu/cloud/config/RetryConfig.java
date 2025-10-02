package com.atguigu.cloud.config;


import feign.Logger;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: 邓晰洋
 * @CreateTime: 2025-09-29 16:42:57
 * @Description:
 * @Version: 1.0
 */
@Configuration
public class RetryConfig {
    @Bean
    public Retryer retryer(){
        return Retryer.NEVER_RETRY;
//        return new Retryer.Default(100,1,3);

    }

    @Bean
    public Logger.Level level(){
        return Logger.Level.FULL;
    }
}
