package com.demo.personal.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import com.demo.personal.model.PersonalInfo;

@Component
@RefreshScope
public class PersonalInfoComponent {
	
	@Value("${personal.name}")
    private String name;
	
	@Value("${personal.surname}")
    private String surname;
	
	public PersonalInfo info(){
		PersonalInfo info =new PersonalInfo();
		info.setName(name);
		info.setSurname(surname);
		return info;
		
	}

}
