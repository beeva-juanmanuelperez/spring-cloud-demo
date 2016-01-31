package com.demo.personal.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.personal.component.PersonalInfoComponent;
import com.demo.personal.model.PersonalInfo;


@RestController
public class PersonalController {
	
	@Autowired
	private PersonalInfoComponent info;
	
	@Value("${service.id}")
    private String id;
	
	@RequestMapping("/")
	public PersonalInfo info() {
		PersonalInfo personalInfo=info.info();
		personalInfo.setId(id);
		return personalInfo;
	}
}