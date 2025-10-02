package com.atguigu.cloud.factory;


import com.fasterxml.jackson.annotation.JsonAnyGetter;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/**
*@Author: 邓晰洋
*@CreateTime: 2025-10-01 10:22:31
*@Description: 
*@Version: 1.0
*/

@Component
public class MyRoutePredicateFactory extends AbstractRoutePredicateFactory<MyRoutePredicateFactory.Config> {
    public MyRoutePredicateFactory() {
        super(Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Collections.singletonList("type");
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return new Predicate<ServerWebExchange>() {
            @Override
            public boolean test(ServerWebExchange serverWebExchange) {
                String type = serverWebExchange.getRequest().getQueryParams().getFirst("type");
                if(type.equalsIgnoreCase(config.type)){
                    return true;
                }else{
                    return false;
                }
            }
        };
    }

    @Validated
    public static class Config{
        @NotNull@Getter@Setter
        private  String  type;
    }
}
