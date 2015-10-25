package com.demo.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Spring Boot main class.
 * @author Juan Manuel Pérez Rodríguez
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class Application {
	public static void main( String[] args ){
	      SpringApplication.run(Application.class, args);
	   }
}
