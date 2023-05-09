package com.trojan.order.controller;/**
 * @Description
 * @Author Trojan
 * @Date 2023/4/19
 * @Version 1.0
 */

import com.trojan.order.feign.ProductFeignService;
import com.trojan.order.feign.StoreFeignService;
import com.trojan.order.pojo.Order;
import com.trojan.order.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import org.checkerframework.checker.units.qual.A;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ClassName OrderController
 * @Description TODO
 * @Author Trojan
 * @Date 2023/4/19
 * @Version 1.0
 */

@RestController
@RequestMapping("/order")
public class OrderController {
    //    @Autowired
//    RestTemplate restTemplate;

    @Resource
    StoreFeignService storeFeignService;
    @Autowired
    ProductFeignService productFeignService;
    @Autowired
    OrderService orderService;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/add")
    public String add() {
        System.out.println("add order ");
//        String retMsg = restTemplate.getForObject("http://store-service/store/add", String.class);
        String retMsg = storeFeignService.add() + productFeignService.query(1);

        return "add order " + retMsg;
    }

    // 插入订单信息
    @RequestMapping("/addOrder")
    @GlobalTransactional
    public String addOrder() {
        Order order = new Order();
        order.setProductId(9);
        order.setStatus(0);
        order.setTotalAmount(100);

        orderService.create(order);

        storeFeignService.reduct(9);

        return "下单成功";
    }

    @RequestMapping("/testFallback")
    public String testFallback() {

        logger.info("testFallback");

        String retMsg = storeFeignService.testFallback();

        return "add order " + retMsg;
    }
}
