package com.trojan.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName StoreFeignService
 * @Description TODO
 * @Author Trojan
 * @Date 2023/4/25
 * @Version 1.0
 */
@FeignClient(name = "store-service", path = "/store", fallback = StoreFeignFallbackService.class)
public interface StoreFeignService {
    @RequestMapping("/add")
    public String add();

    @RequestMapping(value = "/testFallback")
    public String testFallback();

}
