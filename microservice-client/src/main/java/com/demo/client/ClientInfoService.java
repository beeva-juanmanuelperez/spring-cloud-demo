package com.demo.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.client.model.PersonalInfo;
import com.demo.client.model.PostalInfo;
import com.demo.client.model.SalaryInfo;

@FeignClient("zuul")
public interface ClientInfoService {

//	@RequestMapping(method = RequestMethod.GET, value = "/hello")
//	 public String home();
//	
//	@RequestMapping(method = RequestMethod.GET, value = "/location")
//	 public String geoinfo();
//	
//	@RequestMapping(method = RequestMethod.GET, value = "/dateinfo")
//	 public String dateinfo();
	
	@RequestMapping(method = RequestMethod.GET, value = "/salary")
	 public SalaryInfo salaryInfo();
	
	@RequestMapping(method = RequestMethod.GET, value = "/postal")
	 public PostalInfo postalInfo();
	
	@RequestMapping(method = RequestMethod.GET, value = "/personal")
	 public PersonalInfo personalInfo();
}
