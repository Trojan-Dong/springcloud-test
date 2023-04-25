package com.trojan.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName ProductFeignService
 * @Description TODO
 * @Author Trojan
 * @Date 2023/4/25
 * @Version 1.0
 */
@FeignClient(name = "product-service", path = "/product")
public interface ProductFeignService {

    @RequestMapping("/{id}")
    public String query(@PathVariable("id") Integer id);
}
