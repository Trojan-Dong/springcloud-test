package com.trojan.order.controller;/**
 * @Description
 * @Author Trojan
 * @Date 2023/4/19
 * @Version 1.0
 */

import com.trojan.order.feign.ProductFeignService;
import com.trojan.order.feign.StoreFeignService;
import org.checkerframework.checker.units.qual.A;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
    @Autowired
    StoreFeignService storeFeignService;
    @Autowired
    ProductFeignService productFeignService;


    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/add")
    public String add() {
        System.out.println("add order ");
//        String retMsg = restTemplate.getForObject("http://store-service/store/add", String.class);
        String retMsg = storeFeignService.add() + productFeignService.query(1);

        return "add order " + retMsg;
    }


    @RequestMapping("/testFallback")
    public String testFallback() {

        logger.info("testFallback");

        String retMsg = storeFeignService.testFallback();

        return "add order " + retMsg;
    }
}
