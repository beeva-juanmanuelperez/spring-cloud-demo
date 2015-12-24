package com.demo.eureka.configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Juan Manuel Pérez Rodríguez
 */
@Configuration
public class CustomRibbonClientConfiguration {
    /**
     * This RibbonClient overrides the default one. We include a non-default IRule for Load Balancing here.
     * Care: if included in component scan, this bean is used globally for all ribbon clients. See Spring Cloud docs to
     * selectively customizing ribbon clients
     *
     * @return
     */
    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }

}
