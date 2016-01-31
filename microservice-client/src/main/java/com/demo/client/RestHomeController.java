package com.demo.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.client.model.ClientInfo;
import com.demo.client.model.PersonalInfo;
import com.demo.client.model.PostalInfo;
import com.demo.client.model.SalaryInfo;


@RestController
public class RestHomeController {
	
	@Autowired
	private RetrieverClientInfo retrieverClientInfo;
	
//	@RequestMapping("/")
//	public String printPhrase() {
//		 String results = phraseRetriever.home()  + phraseRetriever.geoInfo() + " AND DATE IS : " + phraseRetriever.dateInfo();
//       return results;
//	}
	
	@RequestMapping("/")
	public ClientInfo printPhrase() {
		 return mapperResponse(retrieverClientInfo.personalInfo(),retrieverClientInfo.postalInfo(),retrieverClientInfo.salaryInfo());
	}
	
	private ClientInfo mapperResponse(PersonalInfo personalInfo,PostalInfo postalInfo,SalaryInfo salaryInfo){
		ClientInfo clientInfo=new ClientInfo();
		if (personalInfo!=null){
			clientInfo.setPersonal(personalInfo);
		}
		if (postalInfo!=null){
			clientInfo.setAddress(postalInfo);
		}
		if (salaryInfo!=null){
			clientInfo.setWork(salaryInfo);
		}
		
		return clientInfo;
		
	}
}
