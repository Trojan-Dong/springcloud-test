package com.trojan.order.config;

import com.trojan.order.interceptor.FeignAuthRequestInterceptor;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName FeignConfig
 * @Description TODO
 * @Author Trojan
 * @Date 2023/4/25
 * @Version 1.0
 * <p>
 * question: 不在order包下时日志不生效 与controller包在同一目录下
 */
@Configuration
public class FeignConfig {

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.BASIC;
    }

    @Bean
    public FeignAuthRequestInterceptor feignAuthRequestInterceptor() {
        return new FeignAuthRequestInterceptor();
    }
}
