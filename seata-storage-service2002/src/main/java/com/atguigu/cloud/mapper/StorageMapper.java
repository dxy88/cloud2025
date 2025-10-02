package com.atguigu.cloud.mapper;

import com.atguigu.cloud.entities.Storage;
import com.atguigu.cloud.resp.ResultData;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface StorageMapper extends Mapper<Storage> {
    void declareStorage(@Param("productId") Long productId, @Param("count") Integer count);
}