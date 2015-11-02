package com.demo.person.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.netflix.ribbon.RibbonClientConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author BBVA Open Platform Development Team
 */
@Configuration
public class CustomRibbonClientConfiguration extends RibbonClientConfiguration{
    @Bean
    public IRule ribbonRule(IClientConfig config) {
        RandomRule rule = new RandomRule();
        rule.initWithNiwsConfig(config);
        return rule;
    }
}
