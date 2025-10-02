package com.atguigu.cloud.config;


import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Author: 邓晰洋
 * @CreateTime: 2025-10-02 09:47:28
 * @Description:
 * @Version: 1.0
 */
@Configuration
public class MyRequestOriginParser implements RequestOriginParser {
    @Override
    public String parseOrigin(HttpServletRequest request) {
        String serverName = request.getParameter("serverName");
        return serverName;
    }
}
