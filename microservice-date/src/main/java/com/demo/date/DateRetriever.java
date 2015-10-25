package com.demo.date;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class DateRetriever {

	@Value("${dateinfo.numdays}")
    private Integer numDays;

	@HystrixCommand(fallbackMethod="dateInfoFallback")
	public String dateInfo() {
		DateTime now = DateTime.now();
		return now.minusDays(numDays).toDate().toString();
	}

	public String dateInfoFallback() {
		DateTime now = DateTime.now();
		return now.minusYears(15).toDate().toString();
	}
}