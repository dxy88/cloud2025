package com.atguigu.cloud.mapper;

import com.atguigu.cloud.entities.Account;
import com.atguigu.cloud.resp.ResultData;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface AccountMapper extends Mapper<Account> {
    void declareAccount(@Param("userId") Long userId, @Param("money") Long money);
}