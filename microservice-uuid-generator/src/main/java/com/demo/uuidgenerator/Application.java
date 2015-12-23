package com.demo.uuidgenerator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
@EnableEurekaClient
@RestController
@RefreshScope
public class Application
{
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    @RequestMapping("/")
    public String home() {
        LOGGER.info("Invoked at " + new Date().toString());
        return UUID.randomUUID().toString();
    }
	
    public static void main( String[] args )
    {
    	SpringApplication.run(Application.class, args);
    }
    
}