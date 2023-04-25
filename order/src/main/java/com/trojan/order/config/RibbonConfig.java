package com.trojan.order.config;

import com.alibaba.cloud.nacos.ribbon.NacosRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName RibbonConfig
 * @Description TODO
 * @Author Trojan
 * @Date 2023/4/24
 * @Version 1.0
 */
//@Configuration
public class RibbonConfig {
    /* *
     * @desc 全局配置负载均衡策略
     * @param []
     * @return com.netflix.loadbalancer.IRule
     */
    @Bean
    public IRule iRule() {
        return new NacosRule();
    }
}
