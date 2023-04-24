package com.trojan.order.controller;/**
 * @Description
 * @Author Trojan
 * @Date 2023/4/19
 * @Version 1.0
 */

import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/add")
    public String add() {
        System.out.println("add order ");
        String retMsg = restTemplate.getForObject("http://store-service/store/add", String.class);
        return "add order " + retMsg;
    }
}
