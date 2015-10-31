package com.demo.microserviceHello;


import lombok.Data;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableConfigurationProperties(MyProps.class)
@RefreshScope
public class HelloApp
{
	@Autowired
	private Service service;
	
	@Autowired
	private MyProps props;

	@Value("${myprops.alias}")
    String alias;
	
	@Bean
	@RefreshScope
	public Service service(){
		return new  Service(props.getName());
	}
	
	@RequestMapping("/")
    public String home() {
       
		return "HELLO "+service.getName()+"!" + " , WE ARE WITH " + alias;
    }
	
    public static void main( String[] args )
    {
    	SpringApplication.run(HelloApp.class, args);
    }
    
}
@Data
@RequiredArgsConstructor
class Service{
    private final String name ;
    private Service(){name="UNKNOWN";}
}
 
@Data
@ConfigurationProperties("myprops")
class MyProps{
    private  String name = "WORLD";
}
