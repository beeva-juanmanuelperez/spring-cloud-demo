package com.demo.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.client.model.PersonalInfo;
import com.demo.client.model.PostalInfo;
import com.demo.client.model.SalaryInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class RetrieverClientInfo  {

	@Autowired
	private ClientInfoService clientInfoService;

//	@HystrixCommand(fallbackMethod="retrieveFallbackGeoinfo")
//	public String geoInfo() {
//		return stringClient.geoinfo();
//	}
//
//	@HystrixCommand(fallbackMethod="retrieveFallbackHome")
//	public String home() {
//		
//		return stringClient.home();
//	}
//	
//	@HystrixCommand(fallbackMethod="retrieveFallbackDate")
//	public String dateInfo() {
//		
//		return stringClient.dateinfo();
//	}
	
	@HystrixCommand(fallbackMethod="retrieveFallbackSalary")
	
	public SalaryInfo salaryInfo() {
		
		return clientInfoService.salaryInfo();
	}
	
	@HystrixCommand(fallbackMethod="retrieveFallbackPersonal")

	public PersonalInfo personalInfo() {
		
		return clientInfoService.personalInfo();
	}
	
	@HystrixCommand(fallbackMethod="retrieveFallbackPostal")
	public PostalInfo postalInfo() {
		
		return clientInfoService.postalInfo();
	}
	
	
	public SalaryInfo retrieveFallbackSalary() {
		return null;
	}
	
	public SalaryInfo retrieveFallbackPersonal() {
		return null;
	}
	
	public SalaryInfo retrieveFallbackPostal() {
		return null;
	}
	
	
	
//	public String retrieveFallbackGeoinfo() {
//		return " FAIL FRANCIA";
//	}
//	
//	
//	
//	
//	public String retrieveFallbackHome() {
//		return " HELLO FAIL!";
//	}
//	
//	public String retrieveFallbackDate() {
//		return " SERVICE DATEINFO FAIL";
//	}
}
