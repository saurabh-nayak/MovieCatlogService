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
public class MovieDesciptionServiceCallHelper 
{
	
	@Autowired
	RestTemplate template;
	@Autowired
	ResponseData responseData;
	@HystrixCommand(fallbackMethod = "callfallBackDescription")
     public Object callMovieDescriptionService()
     {
        HttpHeaders requestHeaders = new HttpHeaders();
 		requestHeaders.add("movieCode", "101,102");
 		RequestData requestData= new RequestData();
 		requestData.setStr("starting of request");
 		HttpEntity<RequestData> httpEntity=new HttpEntity<RequestData>(requestData,requestHeaders);
 		ResponseEntity<ResponseData> responseDescription=template.exchange("http://MovieDescription-Service/getMovieDescription", HttpMethod.POST, httpEntity, ResponseData.class);
 		responseData.setListMovie(responseDescription.getBody().getListMovie());
 		return responseData;
     }
	
	public Object callfallBackDescription()
	{
		ResponseData responseData=new ResponseData();
		responseData.setListMovie(Arrays.asList(new Movie(101,"Transaformers","that was fucking shit movie"),
				new Movie(102,"PhirHeraFeri", "Awesome movie")
				));
		return responseData;
	}
}
