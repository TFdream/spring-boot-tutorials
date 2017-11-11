package springboot.mybatis.multidatasource.service.impl;

import springboot.mybatis.multidatasource.domain.OrderDO;
import springboot.mybatis.multidatasource.domain.OrderDOExample;
import springboot.mybatis.multidatasource.mapper.slave.OrderDOMapper;
import springboot.mybatis.multidatasource.service.OrderService;
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
