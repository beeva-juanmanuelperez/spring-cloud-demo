package com.demo.person.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author BBVA Open Platform Development Team
 */
@Configuration
@ConfigurationProperties(prefix = "person")
public class PersonConfigurationProperties {
    private List<String> names;
    private List<String> surnames;
    private String test;

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public List<String> getSurnames() {
        return surnames;
    }

    public void setSurnames(List<String> surnames) {
        this.surnames = surnames;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
