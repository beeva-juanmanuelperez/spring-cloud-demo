package com.demo.person.service;

import com.demo.person.config.PersonConfigurationProperties;
import com.demo.person.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author BEEVA
 */
@Service
public class PersonProfilerImpl implements PersonProfiler {
    @Autowired
    PersonConfigurationProperties properties;

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonProfilerImpl.class);

    @Override
    public Person createPerson() {
        String uuid = null;

        // TODO Why can't we invoke a remote microservice from here?
//        try {
//            uuid= restTemplate.getForObject("http://" + properties.getUuidSourceName(), String.class);
//        } catch (Exception e) {
//            LOGGER.warn("Could not initialize UUID for person");
//        }

        if (properties.getName() != null && properties.getSurname() != null) {

            return new Person.PersonBuilder()
                    .withAge(properties.getAge())
                    .withName(properties.getName())
                    .withSurname(properties.getSurname())
                    .withLocation(properties.getLocation())
                    .withUuid(uuid)
                    .build();
        } else {
            List<String> namePool = properties.getNamePool();
            List<String> surnamePool = properties.getSurnamePool();

            if (namePool == null || namePool.isEmpty()) {
                namePool = Arrays.asList("Unknown");
            }

            if (surnamePool == null || namePool.isEmpty()) {
                surnamePool = Arrays.asList("Unknown");
            }

            Random random = new Random();
            int randomNamePosition = random.nextInt(namePool.size());
            int randomSurnamePosition = random.nextInt(surnamePool.size());

            return new Person.PersonBuilder()
                    .withAge(random.nextInt(53) + 18)
                    .withLocation("Unknown")
                    .withName(namePool.get(randomNamePosition))
                    .withSurname(surnamePool.get(randomSurnamePosition))
                    .withUuid(uuid)
                    .build();

        }
    }
}
