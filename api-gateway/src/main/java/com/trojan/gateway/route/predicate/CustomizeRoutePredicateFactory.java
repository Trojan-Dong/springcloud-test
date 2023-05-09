package com.trojan.gateway.route.predicate;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.GatewayPredicate;
import org.springframework.cloud.gateway.handler.predicate.HeaderRoutePredicateFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;

import javax.validation.constraints.NotEmpty;
import java.util.Collections;
import java.util.function.Predicate;

/**
 * @Description 自定义断言工厂
 * @Author Trojan
 * @Date 2023/5/9
 * @Version 1.0
 */
public class CustomizeRoutePredicateFactory extends AbstractRoutePredicateFactory<CustomizeRoutePredicateFactory.Config> {


    public CustomizeRoutePredicateFactory() {
        super(Config.class);
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return new GatewayPredicate() {
            @Override
            public boolean test(ServerWebExchange exchange) {
                if (CollectionUtils.isEmpty(exchange.getRequest().getQueryParams().get(config.param))) {
                    return false;
                } else {
                    return true;
                }
            }
        };
    }

    //用于接收配置文件中的断言信息
    @Validated
    public static class Config {

        @NotEmpty
        private String param;

        private String regexp;

        public String getParam() {
            return param;
        }

        public Config setParam(String param) {
            this.param = param;
            return this;
        }

        public String getRegexp() {
            return regexp;
        }

        public Config setRegexp(String regexp) {
            this.regexp = regexp;
            return this;
        }

    }
}


