package com.demo.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class PhraseRetriever {

	@Autowired
	private StringClient stringClient;

	@HystrixCommand(fallbackMethod="retrieveFallbackGeoinfo")
	public String geoInfo() {
		return stringClient.geoinfo();
	}

	@HystrixCommand(fallbackMethod="retrieveFallbackHome")
	public String home() {
		
		return stringClient.home();
	}
	
	@HystrixCommand(fallbackMethod="retrieveFallbackDate")
	public String dateInfo() {
		
		return stringClient.dateinfo();
	}
	
	public String retrieveFallbackGeoinfo() {
		return " FAIL FRANCIA";
	}
	
	public String retrieveFallbackHome() {
		return " HELLO FAIL!";
	}
	
	public String retrieveFallbackDate() {
		return " SERVICE DATEINFO FAIL";
	}
}
