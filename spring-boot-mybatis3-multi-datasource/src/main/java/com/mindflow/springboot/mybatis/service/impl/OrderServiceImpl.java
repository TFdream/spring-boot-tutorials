package com.mindflow.springboot.mybatis.service.impl;

import com.mindflow.springboot.mybatis.domain.OrderDO;
import com.mindflow.springboot.mybatis.domain.OrderDOExample;
import com.mindflow.springboot.mybatis.mapper.slave.OrderDOMapper;
import com.mindflow.springboot.mybatis.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ricky Fung
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDOMapper orderDOMapper;

    @Override
    public List<OrderDO> getOrders(Long userId) {
        OrderDOExample example = new OrderDOExample();
        example.createCriteria().andUserIdEqualTo(userId);
        return orderDOMapper.selectByExample(example);
    }

    @Override
    public int insert(OrderDO orderDO) {
        return orderDOMapper.insert(orderDO);
    }
}
