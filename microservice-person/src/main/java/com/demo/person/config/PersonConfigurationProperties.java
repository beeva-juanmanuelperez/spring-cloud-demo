package com.demo.person.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author BEEVA
 */
@Configuration
@ConfigurationProperties(prefix = "person")
public class PersonConfigurationProperties {
    private List<String> namePool;
    private List<String> surnamePool;
    private String name;
    private String surname;
    private String location;
    private int age;
    private String uuidSourceName;

    public String getUuidSourceName() {
        return uuidSourceName;
    }

    public void setUuidSourceName(String uuidSourceName) {
        this.uuidSourceName = uuidSourceName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getNamePool() {
        return namePool;
    }

    public void setNamePool(List<String> namePool) {
        this.namePool = namePool;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<String> getSurnamePool() {
        return surnamePool;
    }

    public void setSurnamePool(List<String> surnamePool) {
        this.surnamePool = surnamePool;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
