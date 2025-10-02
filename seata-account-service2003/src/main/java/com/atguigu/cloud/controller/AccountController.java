package com.atguigu.cloud.controller;


import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @Author: 邓晰洋
 * @CreateTime: 2025-10-02 18:05:06
 * @Description:
 * @Version: 1.0
 */
@RestController
public class AccountController {
    @Resource
    private AccountService accountService;
    @PostMapping("/account/decrease")
    public ResultData declareAccount(@RequestParam("userId")Long userId,
                                     @RequestParam("money")Long money) throws InterruptedException {
        accountService.declareAccount(userId,money);
        return ResultData.success("修改成功");
    }
}
