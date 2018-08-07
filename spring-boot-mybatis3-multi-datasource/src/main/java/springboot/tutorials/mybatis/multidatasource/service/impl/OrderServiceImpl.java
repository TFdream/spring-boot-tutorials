package springboot.tutorials.mybatis.multidatasource.service.impl;

import springboot.tutorials.mybatis.multidatasource.domain.OrderDO;
import springboot.tutorials.mybatis.multidatasource.domain.OrderDOExample;
import springboot.tutorials.mybatis.multidatasource.mapper.bar.OrderDOMapper;
import springboot.tutorials.mybatis.multidatasource.service.OrderService;
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
