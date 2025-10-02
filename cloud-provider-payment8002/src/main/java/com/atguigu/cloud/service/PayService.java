package com.atguigu.cloud.service;


import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.entities.PayDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 邓晰洋
 * @CreateTime: 2025-09-29 09:08:30
 * @Description:
 * @Version: 1.0
 */
@Service
public interface PayService {
     int add(Pay pay);
     int delete(Integer id);
     int update(PayDTO payDTO);
     Pay getById(Integer id);
     List<Pay>getAll();
}
