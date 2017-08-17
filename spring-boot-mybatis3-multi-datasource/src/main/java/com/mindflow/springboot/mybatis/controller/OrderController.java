package com.mindflow.springboot.mybatis.controller;

import com.mindflow.springboot.mybatis.domain.OrderDO;
import com.mindflow.springboot.mybatis.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author Ricky Fung
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/orders/{userId}", method= RequestMethod.GET)
    public List<OrderDO> listOrder(@PathVariable Long userId) {
        List<OrderDO> list = orderService.getOrders(userId);
        if(list==null) {
            list = Collections.EMPTY_LIST;
        }
        return list;
    }

    @RequestMapping(value = "/order/add", method= RequestMethod.GET)
    public OrderDO addOrder(@RequestParam Long userId) {
        OrderDO orderDO = new OrderDO();
        orderDO.setUserId(userId);
        orderDO.setStatus((short) 0);
        orderDO.setCreateTime(new Date());
        orderDO.setModifyTime(new Date());
        orderService.insert(orderDO);
        return orderDO;
    }

}
