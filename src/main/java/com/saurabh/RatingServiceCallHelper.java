package com.saurabh;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class RatingServiceCallHelper 
{
	@Autowired
	RestTemplate template;
	
//	@HystrixCommand(fallbackMethod = "callfallBackRatingService")
     public Object callRatingService()
     {
    	 HttpHeaders requestHeaders = new HttpHeaders();
 		requestHeaders.add("movieCode", "101,102");
 		RequestData requestData= new RequestData();
 		requestData.setStr("starting of request");
 		HttpEntity<RequestData> httpEntity=new HttpEntity<RequestData>(requestData,requestHeaders);
 		ResponseEntity<ResponseData> responseDescription=template.exchange("http://RatingService/getRating", HttpMethod.POST, httpEntity,ResponseData.class);
 		return responseDescription.getBody();
     }
	
	public Object callfallBackRatingService()
	{
		ResponseData responseData=new ResponseData();
		responseData.setRatingList(Arrays.asList(new MovieRating(101,3),new MovieRating(102, 5)));
		return responseData;
	}
}
