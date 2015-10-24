package com.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.turbine.amqp.EnableTurbineAmqp;

/**
 * @author BBVA OpenPlatform Developer Team
 */
@SpringBootApplication
@EnableTurbineAmqp
public class Turbine {


    public static void main(String[] args){

        new SpringApplicationBuilder(Turbine.class).run(args);
    }
}
