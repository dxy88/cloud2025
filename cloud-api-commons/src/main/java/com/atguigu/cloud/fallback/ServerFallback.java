package com.atguigu.cloud.fallback;


import com.atguigu.cloud.apis.PayServerApi;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.resp.ReturnCodeEnum;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: 邓晰洋
 * @CreateTime: 2025-10-02 11:19:10
 * @Description:
 * @Version: 1.0
 */
@Configuration
public class ServerFallback implements PayServerApi {
    @Override
    public ResultData serverByOrderNo(Integer id) {
        return ResultData.fail(ReturnCodeEnum.RC500.getCode(), "当前服务器宕机或不可用...");
    }
}
