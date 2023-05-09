package com.trojan.order.mapper;

import com.trojan.order.pojo.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    Order selectByPrimaryKey(Integer id);

    List<Order> selectAll();

    int updateByPrimaryKey(Order record);
}