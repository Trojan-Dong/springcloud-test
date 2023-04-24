package com.trojan.ribbon.rule;/**
 * @Description
 * @Author Trojan
 * @Date 2023/4/25
 * @Version 1.0
 */

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @ClassName CustomizeRule
 * @Description TODO
 * @Author Trojan
 * @Date 2023/4/25
 * @Version 1.0
 */
public class CustomizeRule extends AbstractLoadBalancerRule {
    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }
//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
    @Override
    public Server choose(Object key) {
        ILoadBalancer iLoadBalancer = this.getLoadBalancer();

        //获取当前请求的服务实例
        List<Server> serverList = iLoadBalancer.getReachableServers();

        int random = ThreadLocalRandom.current().nextInt(serverList.size());

        Server server = serverList.get(random);
        if (!server.isAlive()) {
            return null;
        }
        return server;
    }
}
