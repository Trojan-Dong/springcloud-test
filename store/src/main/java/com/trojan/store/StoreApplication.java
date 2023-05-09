package com.trojan.store;/**
 * @Description
 * @Author Trojan
 * @Date 2023/4/20
 * @Version 1.0
 */

import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName StoreApplication
 * @Description TODO
 * @Author Trojan
 * @Date 2023/4/20
 * @Version 1.0
 */
@SpringBootApplication
@MapperScan("com.trojan.store.mapper")
public class StoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(StoreApplication.class, args);
    }


    @Bean
    public SentinelResourceAspect sentinelResourceAspect() {
        return new SentinelResourceAspect();
    }
}
