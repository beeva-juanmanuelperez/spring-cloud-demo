package com.demo.postal.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import com.demo.postal.model.PostalInfo;

@Component
@RefreshScope
public class PostalInfoComponent {
	
	@Value("${postal.country}")
    private String country;
	
	@Value("${postal.province}")
    private String province;
	
	@Value("${postal.locality}")
    private String locality;
	
	@Value("${postal.postalcode}")
    private String postalCode;
	
	public PostalInfo info(){
		PostalInfo info=new PostalInfo();
		 info.setCountry(country);
		 info.setProvince(province);
		 info.setLocality(locality);
		 info.setPostalCode(postalCode);
		 return info;
		
	}

}
