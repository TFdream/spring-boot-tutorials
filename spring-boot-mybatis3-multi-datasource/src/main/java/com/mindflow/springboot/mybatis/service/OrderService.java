package com.mindflow.springboot.mybatis.service;

import com.mindflow.springboot.mybatis.domain.OrderDO;
import java.util.List;

/**
 * @author Ricky Fung
 */
public interface OrderService {

    List<OrderDO> getOrders(Long userId);

    int insert(OrderDO orderDO);
}
