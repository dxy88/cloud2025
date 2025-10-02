package com.atguigu.cloud.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.cglib.core.Block;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 邓晰洋
 * @CreateTime: 2025-10-02 08:42:30
 * @Description:
 * @Version: 1.0
 */
@RestController
public class RateLimiterController {
    @GetMapping("/rateLimit/byUrl")
    public String byUrl(){
        return  "this is a url....";
    }
    @GetMapping("/rateLimit/byResource/{id}")
    @SentinelResource(value="byResource",blockHandler = "resourceHandler",fallback = "resourceFallback")
    public String byResource(@PathVariable("id")Integer id){
        if(id==0){
            throw new RuntimeException("服务异常");
        }
        return "this is a resource"+id;
    }
    public String resourceHandler(Integer id, BlockException blockException){
        return "resourceHandlerException"+"-"+"异常id:"+id;
    }
    public String resourceFallback(Integer id,Throwable e){
        return "服务fallback,o(╥﹏╥)o..."+id+"\n"+e.getMessage();
    }
    @GetMapping("/rateLimiter/hot")
    @SentinelResource(value="rateHot",blockHandler = "hotBlock")
    public String hot(@RequestParam(value="p1",required = false)String p1,
                      @RequestParam(value="p2",required = false)String p2){
        return "hot is success...";
    }
    public String hotBlock(String p1, String p2, BlockException blockException){
        return "hot block o(╥﹏╥)o....";
    }
}
























































