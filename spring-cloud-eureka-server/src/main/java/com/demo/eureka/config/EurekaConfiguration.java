package com.demo.eureka.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Juan Manuel Pérez Rodríguez
 */
@Configuration
public class EurekaConfiguration {
    /**
     * To change the Ribbon Load Balancing Rule, we just need to define a Bean with an implementation of IRule.
     * Care: this bean is used globally for all ribbon clients.
     *
     * @return
     */
    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }

}
