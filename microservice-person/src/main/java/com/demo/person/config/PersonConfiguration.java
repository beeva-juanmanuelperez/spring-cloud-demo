package com.demo.person.config;

import com.demo.person.model.Person;
import com.demo.person.service.PersonProfiler;
import com.demo.person.service.PersonProfilerImpl;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author BBVA Open Platform Development Team
 */
@Configuration
public class PersonConfiguration {
    @Bean
    public PersonProfiler personProfiler() {
        return new PersonProfilerImpl();
    }

    @Bean
    public Person person() {
        return personProfiler().createPerson();
    }
}
