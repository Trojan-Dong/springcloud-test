package com.trojan.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName ProductController
 * @Description TODO
 * @Author Trojan
 * @Date 2023/4/20
 * @Version 1.0
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Value("${server.port}")
    String port;

    @RequestMapping("/reduce")
    public String add() {
        System.out.println("reduce product");
        return "reduce product" + port;
    }
}
