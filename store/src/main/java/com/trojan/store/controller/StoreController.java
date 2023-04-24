package com.trojan.store.controller;/**
 * @Description
 * @Author Trojan
 * @Date 2023/4/20
 * @Version 1.0
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName StoreController
 * @Description TODO
 * @Author Trojan
 * @Date 2023/4/20
 * @Version 1.0
 */
@RestController
@RequestMapping("/store")
public class StoreController {
    @Value("${server.port}")
    String port;

    @RequestMapping("/add")
    public String add() {
        System.out.println("add store");
        return "add store" + port;
    }
}
