package com.demo.zuul.configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Juan Manuel Pérez Rodríguez
 */
@Configuration
public class ZuulConfiguration {
    /**
     * This RibbonClient overrides the default one. We include a non-default IRule for Load Balancing here.
     *
     * @return
     */
    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }
}
