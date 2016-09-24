package com.demo.person.config;

import com.demo.person.model.Person;
import com.demo.person.service.PersonProfiler;
import com.demo.person.service.PersonProfilerImpl;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Juan Manuel Pérez Rodríguez
 */
@Configuration
public class PersonConfiguration {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public PersonProfiler personProfiler() {
        return new PersonProfilerImpl();
    }

    @Bean
    public Person person() {
        return personProfiler().createPerson();
    }

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

