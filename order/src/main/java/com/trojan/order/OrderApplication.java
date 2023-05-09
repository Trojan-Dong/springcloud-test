package com.trojan.order;/**
 * @Description
 * @Author Trojan
 * @Date 2023/4/20
 * @Version 1.0
 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.concurrent.TimeUnit;

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
@MapperScan("com.trojan.order.mapper")
public class OrderApplication {
    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(OrderApplication.class, args);
//        while(true){
//            System.out.println(applicationContext.getEnvironment().getProperty("user.name"));
//            System.out.println(applicationContext.getEnvironment().getProperty("user.space"));
//            System.out.println(applicationContext.getEnvironment().getProperty("user.config"));
//            TimeUnit.SECONDS.sleep(3);
//        }

    }

//    @Bean
//    @LoadBalanced
//    public RestTemplate restTemplate(RestTemplateBuilder builder) {
//        return builder.build();
//    }
}
