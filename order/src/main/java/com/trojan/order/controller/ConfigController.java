package com.trojan.order.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @Description TODO
 * @Author Trojan
 * @Date 2023/5/4
 * @Version 1.0
 */

@RestController
@RequestMapping("/config")
@RequestScope //使用@value进行值的注入时，需要使用此注解动态获取nacos远程配置的值
public class ConfigController {

    @Value("${user.config}")
    String config;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/getConfig")
    public String getConfig() throws InterruptedException {
        Thread thread = Thread.currentThread();
        logger.info("currentThreadId:{}", thread.getId());
        Thread.sleep(5 * 1000);

        return config + thread.getId();
    }
}
