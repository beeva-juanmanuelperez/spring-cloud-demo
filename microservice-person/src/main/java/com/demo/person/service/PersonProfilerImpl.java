package com.demo.person.service;

import com.demo.person.config.PersonConfigurationProperties;
import com.demo.person.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author Juan Manuel Pérez Rodríguez
 */
@Service
public class PersonProfilerImpl implements PersonProfiler {
    @Autowired
    PersonConfigurationProperties properties;

    @Override
    public Person createPerson() {
        if (properties.getName() != null && properties.getSurname() != null) {

            return new Person.PersonBuilder()
                    .withAge(properties.getAge())
                    .withName(properties.getName())
                    .withSurname(properties.getSurname())
                    .withLocation(properties.getLocation())
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
                    .build();

        }
    }
}
