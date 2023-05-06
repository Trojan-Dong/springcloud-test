package com.trojan.order.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

/**
 * @Description TODO
 * @Author Trojan
 * @Date 2023/5/4
 * @Version 1.0
 */


public class FeignAuthRequestInterceptor implements RequestInterceptor {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void apply(RequestTemplate template) {
        String access_token = UUID.randomUUID().toString();
        template.header("Authorization", access_token);
        logger.info("feign interceptro{}",String.valueOf(template.headers().get("Authorization")));
    }
}
