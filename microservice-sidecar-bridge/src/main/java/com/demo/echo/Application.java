package com.demo.echo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;

@SpringBootApplication
@EnableEurekaClient
@EnableSidecar
public class Application
{
    public static void main( String[] args )
    {
    	SpringApplication.run(Application.class, args);
    }
    
}