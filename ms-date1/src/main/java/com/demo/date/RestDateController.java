package com.demo.date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.date.DateRetriever;


@RestController
public class RestDateController {
	
	@Autowired
	private DateRetriever phraseRetriever;
	
	@Value("${service.date}")
    String service;
	
	@RequestMapping("/")
	public String printPhrase() {
		 String results = phraseRetriever.dateInfo() ;
       return results + " service name :" + service;
	}
}
