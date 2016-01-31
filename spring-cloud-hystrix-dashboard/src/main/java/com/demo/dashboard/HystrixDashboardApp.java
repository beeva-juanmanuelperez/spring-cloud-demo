package com.demo.dashboard;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;


@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardApp
{
    public static void main( String[] args )
    {
    	new SpringApplicationBuilder(HystrixDashboardApp.class).web(true).run(args);
    }
}
