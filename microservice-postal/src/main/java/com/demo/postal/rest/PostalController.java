package com.demo.postal.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.postal.component.PostalInfoComponent;
import com.demo.postal.model.PostalInfo;


@RestController
public class PostalController {
	
	@Autowired
	private PostalInfoComponent info;
	
	@RequestMapping("/")
	public PostalInfo info() {
		return info.info();
	}
}
