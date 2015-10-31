package com.demo.bbva.configserver;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Spring Boot main class.
 * @author Juan Manuel Pérez Rodríguez
 */
@SpringBootApplication
@EnableConfigServer
public class Application {
	public static void main(String[] args) throws Exception {
		new SpringApplicationBuilder(Application.class).web(true).run(args);
	 }
}
