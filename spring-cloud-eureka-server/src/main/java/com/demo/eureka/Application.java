package com.demo.eureka;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


/**
 * Spring Boot main class.
 * @author BEEVA
 */
@SpringBootApplication
@EnableEurekaServer
public class Application
{
   public static void main(String[] args) {
      new SpringApplicationBuilder(Application.class).web(true).run(args);
   }
}