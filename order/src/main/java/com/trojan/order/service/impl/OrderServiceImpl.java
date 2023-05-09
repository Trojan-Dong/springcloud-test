package com.trojan.order.service.impl;

import com.trojan.order.mapper.OrderMapper;
import com.trojan.order.pojo.Order;
import com.trojan.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    OrderMapper orderMapper;

//    @Autowired
//    RestTemplate restTemplate;

    /**
     * 下单
     *
     * @return
     */
    @Transactional
    @Override
    public Order create(Order order) {
        // 插入能否成功？
        orderMapper.insert(order);


        // 扣减库存 能否成功？
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
        paramMap.add("productId", order.getProductId());

//        String msg = restTemplate.postForObject("http://localhost:8071/stock/reduct", paramMap, String.class);



        return order;
    }


}
