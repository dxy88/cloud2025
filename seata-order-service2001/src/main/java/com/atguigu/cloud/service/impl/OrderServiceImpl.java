package com.atguigu.cloud.service.impl;


import com.atguigu.cloud.apis.AccountFeignApi;
import com.atguigu.cloud.apis.StorageFeignApi;
import com.atguigu.cloud.entities.Order;
import com.atguigu.cloud.mapper.OrderMapper;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.resp.ReturnCodeEnum;
import com.atguigu.cloud.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import jakarta.annotation.Resource;
import org.apache.ibatis.javassist.Loader;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.crypto.Cipher;

/**
 * @Author: 邓晰洋
 * @CreateTime: 2025-10-02 16:33:29
 * @Description:
 * @Version: 1.0
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private StorageFeignApi storageFeignApi;
    @Resource
    private AccountFeignApi accountFeignApi;
    @Override
    @GlobalTransactional(name="dxy666",rollbackFor = Exception.class)
    public ResultData create(Order order) {
        order.setStatus(0);
        int result = orderMapper.insertSelective(order);
        Order simOrder=null;
        if(result>0){
            /**
             * 下单成功
             */
           simOrder = orderMapper.selectOne(order);
           storageFeignApi.declareStorage(simOrder.getProductId(),simOrder.getCount());
           accountFeignApi.declareAccount(simOrder.getUserId(),simOrder.getMoney());
           simOrder.setStatus(1);
           Example example=new Example(Order.class);
           Example.Criteria criteria = example.createCriteria();
           criteria.andEqualTo("userId",simOrder.getUserId());
           criteria.andEqualTo("productId",simOrder.getProductId());
            int i = orderMapper.updateByExampleSelective(simOrder, example);
            if(i>0){
                return ResultData.success(simOrder);
            }
        }
        return ResultData.fail(ReturnCodeEnum.RC500.getCode(),"下单请求失败");
    }
}

















































