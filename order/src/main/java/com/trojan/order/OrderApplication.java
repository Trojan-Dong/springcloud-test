package com.trojan.order;/**
 * @Description
 * @Author Trojan
 * @Date 2023/4/20
 * @Version 1.0
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName OrderApplication
 * @Description TODO
 * @Author Trojan
 * @Date 2023/4/20
 * @Version 1.0
 */
@SpringBootApplication
//@RibbonClients(value = {
//        @RibbonClient(name = "store-service", configuration = RibbonConfig.class)
//})
@EnableFeignClients
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

//    @Bean
//    @LoadBalanced
//    public RestTemplate restTemplate(RestTemplateBuilder builder) {
//        return builder.build();
//    }
}
