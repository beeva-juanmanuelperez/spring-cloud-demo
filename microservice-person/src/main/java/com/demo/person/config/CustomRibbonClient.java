package com.demo.person.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Juan Manuel Pérez Rodríguez
 */
@Configuration
@RibbonClient(name = "ribbonClient", configuration = CustomRibbonClientConfiguration.class)
public class CustomRibbonClient {
    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }
}