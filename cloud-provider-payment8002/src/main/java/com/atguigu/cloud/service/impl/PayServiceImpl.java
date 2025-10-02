package com.atguigu.cloud.service.impl;


import cn.hutool.core.bean.BeanUtil;
import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.mapper.PayMapper;
import com.atguigu.cloud.service.PayService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 邓晰洋
 * @CreateTime: 2025-09-29 09:08:55
 * @Description:
 * @Version: 1.0
 */
@Service
public class PayServiceImpl  implements PayService {
    @Resource
    private PayMapper payMapper;

    @Override
    public int add(Pay pay) {
        return payMapper.insertSelective(pay);
    }

    @Override
    public int delete(Integer id) {
        return payMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(PayDTO payDTO) {
        Pay pay = BeanUtil.copyProperties(payDTO, Pay.class);
        return payMapper.updateByPrimaryKeySelective(pay);
    }

    @Override
    public Pay getById(Integer id) {
        Pay pay = payMapper.selectByPrimaryKey(id);
        return pay;
    }

    @Override
    public List<Pay> getAll() {
        List<Pay> pays = payMapper.selectAll();
        return pays;
    }
}
