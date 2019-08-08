package io.dreamstudio.springboot.multi.mapper;

import io.dreamstudio.springboot.multi.BaseSpringBootJUnitTest;
import io.dreamstudio.springboot.multi.mapper.two.OrderMapper;
import io.dreamstudio.springboot.multi.model.Order;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author Ricky Fung
 */
public class OrderMapperTest extends BaseSpringBootJUnitTest {

    @Resource
    private OrderMapper orderMapper;

    private Long id = 1L;

    @Test
    @Ignore
    public void testQuery() {
        Order order = orderMapper.selectByPrimaryKey(id);
        System.out.println(order);
    }

    @Test
    @Ignore
    public void testInsert() {
        Order order = new Order();
        order.setOrderId(121L);
        order.setUserId(15L);
        order.setMemo("dd");
        order.setCreateTime(new Date());
        order.setUpdateTime(new Date());
        orderMapper.insert(order);

        System.out.println(order.getId());
    }
}
