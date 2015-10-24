package com.demo.location;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@RestController
@EnableAutoConfiguration
@EnableEurekaClient
@EnableCircuitBreaker
@RefreshScope
public class LocationApp 
{
	@Value("${location.location}")
	private String location;
	
    @RequestMapping("/")
    String home() {
        return " WE ARE IN " + location;
    }
 
    public static void main(String[] args) throws Exception {
        SpringApplication.run(LocationApp.class, args);
    }
}
