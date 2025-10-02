package com.atguigu.cloud.factory;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;

/**
 * @Author: 邓晰洋
 * @CreateTime: 2025-10-01 13:51:29
 * @Description:
 * @Version: 1.0
 */
@Component
@Slf4j
public class MyGlobalFactory implements GlobalFilter, Ordered {
    private static final String START_TIME_VALUE="start_time_value";
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        exchange.getAttributes().put(START_TIME_VALUE,System.currentTimeMillis());
        return chain.filter(exchange).then(Mono.fromRunnable(()->{
            long startTime =(long) exchange.getAttributes().get(START_TIME_VALUE);
            long endTime = System.currentTimeMillis();
            URI uri = exchange.getRequest().getURI();
            String host = uri.getHost();
            int port = uri.getPort();
            String path = uri.getPath();
            String rawQuery = uri.getRawQuery();
            log.info("主机：{}",host);
            log.info("端口：{}",port);
            log.info("请求路径：{}",path);
            log.info("请求参数：{}",rawQuery);
            log.info("请求耗时：{}",(endTime-startTime)+"ms");
            log.info("结束当前{}"+"=================================");
            System.out.println();
        }));
    }

    @Override
    public int getOrder() {
        return 0;
    }
}





















































