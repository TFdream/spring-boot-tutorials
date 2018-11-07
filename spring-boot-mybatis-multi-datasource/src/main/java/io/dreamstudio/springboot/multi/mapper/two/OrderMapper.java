package io.dreamstudio.springboot.multi.mapper.two;

import io.dreamstudio.springboot.multi.model.Order;

/**
 * @author Ricky Fung
 */
public interface OrderMapper {

    int insert(Order order);

    int insertSelective(Order order);

    Order selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Order order);

    int deleteByPrimaryKey(Long id);
}
