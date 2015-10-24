package com.demo.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("zuul")
public interface StringClient {

	@RequestMapping(method = RequestMethod.GET, value = "/microservicehello")
	 public String home();
	
	@RequestMapping(method = RequestMethod.GET, value = "/location")
	 public String geoinfo();
	
	@RequestMapping(method = RequestMethod.GET, value = "/dateinfo")
	 public String dateinfo();
}
