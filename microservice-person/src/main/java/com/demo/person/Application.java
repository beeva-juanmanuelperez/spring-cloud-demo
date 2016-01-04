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
import org.springframework.http.MediaType;
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
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    /**
     * This instance of RestTemplate is annotated with @LoadBalanced, so it will automatically
     * use Ribbon to find microservices registered in Eureka directly from its identifier
     */
    @Autowired @LoadBalanced
    RestTemplate restTemplate;

    @Autowired
    private Person person;

    @Value("${server.port}")
    private int port;

    @Value("${microservice.uuid-generator}")
    String uuidGeneratorName;

    @RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public Person home(@RequestParam(required = false) String text) {
        if (person.getUuid() == null) {
            String uuid= restTemplate.getForObject("http://" + uuidGeneratorName, String.class);
            person.setUuid(uuid);
        }

        LOGGER.info("This person is " + person);

        return person;
    }
	
    public static void main( String[] args )
    {
    	SpringApplication.run(Application.class, args);
    }
    
}