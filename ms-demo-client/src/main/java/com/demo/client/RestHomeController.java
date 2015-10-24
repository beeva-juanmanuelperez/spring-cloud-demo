package com.demo.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RestHomeController {
	
	@Autowired
	private PhraseRetriever phraseRetriever;
	
	@RequestMapping("/")
	public String printPhrase() {
		 String results = phraseRetriever.home()  + phraseRetriever.geoInfo() + " AND DATE IS : " + phraseRetriever.dateInfo();
       return results;
	}
}
