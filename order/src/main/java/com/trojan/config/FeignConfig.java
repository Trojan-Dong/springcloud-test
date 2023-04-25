package com.trojan.config;/**
 * @Description
 * @Author Trojan
 * @Date 2023/4/25
 * @Version 1.0
 */

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName FeignConfig
 * @Description TODO
 * @Author Trojan
 * @Date 2023/4/25
 * @Version 1.0
 */
@Configuration
public class FeignConfig {


    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
