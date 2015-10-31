package com.demo.echo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@SpringBootApplication
@EnableEurekaClient
@RestController
@RefreshScope
public class Application
{

    @RequestMapping("/")
    public String home() {
        return UUID.randomUUID().toString();
    }
	
    public static void main( String[] args )
    {
    	SpringApplication.run(Application.class, args);
    }
    
}