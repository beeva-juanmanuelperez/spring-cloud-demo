package com.demo.person.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import org.springframework.cloud.netflix.ribbon.RibbonClientConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author BBVA Open Platform Development Team
 */
@Configuration
public class CustomRibbonClientConfiguration extends RibbonClientConfiguration{
    @Bean
    public ILoadBalancer ribbonLoadBalancer(IClientConfig config,
                                            ServerListFilter<Server> filter) {
        ZoneAwareLoadBalancer<Server> balancer = new ZoneAwareLoadBalancer<Server>(config);
        balancer.setFilter(filter);
        balancer.setRule(new RandomRule());
        return balancer;
    }
}
