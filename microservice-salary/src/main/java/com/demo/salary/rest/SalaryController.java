package com.demo.salary.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.salary.component.SalaryInfoComponent;
import com.demo.salary.model.SalaryInfo;


@RestController
public class SalaryController {
	
	@Autowired
	private SalaryInfoComponent info;
	
	@RequestMapping("/")
	public SalaryInfo info() {
		 return info.info();
	}
}
