package com.trojan.order.feign;

import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author Trojan
 * @Date 2023/5/7
 * @Version 1.0
 */

@Component
public class StoreFeignFallbackService implements StoreFeignService {
    @Override
    public String add() {
        return null;
    }

    @Override
    public String testFallback() {
        return "fallback 服务降级";
    }

    @Override
    public String reduct(Integer productId) {
        return null;
    }
}
