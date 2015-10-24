package com.demo.bbva.configserver;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerApp {

	public static void main(String[] args) throws Exception {

		new SpringApplicationBuilder(ConfigServerApp.class).web(true).run(args);
	 }
}
