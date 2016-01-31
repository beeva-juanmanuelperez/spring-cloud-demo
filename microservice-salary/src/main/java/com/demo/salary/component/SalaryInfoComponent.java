package com.demo.salary.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import com.demo.salary.model.SalaryInfo;

@Component
@RefreshScope
public class SalaryInfoComponent {
	
	@Value("${salary.category}")
    private String category;
	
	@Value("${salary.salary}")
    private Integer salary;
	
	public SalaryInfo info(){
		SalaryInfo info=new SalaryInfo();
		 info.setCategory(category);
		 info.setSalary(salary);
		 return info;
		
	}

}
