package com.demo.person;

import com.demo.person.config.PersonConfigurationProperties;
import com.demo.person.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import java.net.InetAddress;

@SpringBootApplication
@EnableEurekaClient
@RestController
@RefreshScope
public class Application
{
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    /**
     * This instance of RestTemplate is annotated with @LoadBalanced, so it will automatically
     * use Ribbon to find microservices registered in Eureka directly from its id
     */
    @Autowired @LoadBalanced
    RestTemplate restTemplate;

    @Autowired
    private Person person;

    @Value("${server.port}")
    private int port;

    @Value("${microservice.uuid-generator}")
    String invokedMicroservice;

    @Autowired
    private PersonConfigurationProperties properties;

    @RequestMapping("/")
    public String home(@RequestParam(required = false) String text) {
        String domain = "unknown";

        String results = restTemplate.getForObject("http://" + invokedMicroservice, String.class);

        LOGGER.info("This person is " + person);

        return "<h1>" +
                person.getName() + " " +
                person.getSurname() + "</h1>" +
                "<p><strong>Age</strong> " + person.getAge() + " years old</p>" +
                "<p><strong>Location</strong> " + person.getLocation() + "</p>" +
                "<p><strong>Request id</strong> " + results + "</p>"
        ;
    }
	
    public static void main( String[] args )
    {
    	SpringApplication.run(Application.class, args);
    }
    
}