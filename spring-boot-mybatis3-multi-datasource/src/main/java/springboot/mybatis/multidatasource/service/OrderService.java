package springboot.mybatis.multidatasource.service;

import springboot.mybatis.multidatasource.domain.OrderDO;
import java.util.List;

/**
 * @author Ricky Fung
 */
public interface OrderService {

    List<OrderDO> getOrders(Long userId);

    int insert(OrderDO orderDO);
}
