package com.demo.echo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RestController
@RefreshScope
public class Application
{
	@Value("${microservice.invoked}")
    String invokedMicroservice;

    @Autowired @LoadBalanced
    private RestTemplate restTemplate;
	
	@RequestMapping("/")
    public String home(@RequestParam(required = false) String text) {
        String results = restTemplate.getForObject("http://" + invokedMicroservice, String.class);

        return "<h1>Echo microservice</h1>" +
                "<p>You said : " + (text == null ? "Nothing :(" : text) + "</p>" +
                "<p>This is a random UUID generated from microservice-uuid-generator: " + results + "</p>"

        ;
    }
	
    public static void main( String[] args )
    {
    	SpringApplication.run(Application.class, args);
    }
    
}