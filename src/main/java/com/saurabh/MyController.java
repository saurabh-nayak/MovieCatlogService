package com.saurabh;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RefreshScope
public class MyController {
	
	@Autowired
	RestTemplate template;
	@Autowired
	MovieDesciptionServiceCallHelper descriptionService;
	@Autowired
	RatingServiceCallHelper ratingServiceCallHelper;
	@Autowired
	ResponseData responseData;
	@Autowired
	MovieDescriptionFeignProxy movieDescriptionFeignProxy;
	@Autowired
	MovieRatingFeignProxy movieRatingFeignProxy;
	@Autowired
	ZullApiGateWayFeignProxy zullApiGateWayFeignProxy;
//	@HystrixCommand(fallbackMethod = "getFallBackMovies")
	@RequestMapping("/movie")
	public ResponseData getMovies()
	{
//		List<Movie> listMovie= Arrays.asList(
//				new Movie(101,"Transformers","Hollywoord"),
//				new Movie(102,"badla","tollywood")
//				); 
//		Integer i=template.getForObject("http://localhost:8080/getRating", Integer.class);
//		HttpHeaders requestHeaders = new HttpHeaders();
//		requestHeaders.add("movieCode", "101,102");
//		RequestData requestData= new RequestData();
//		requestData.setStr("starting of request");
//		HttpEntity<RequestData> httpEntity=new HttpEntity<RequestData>(requestData,requestHeaders);
//		ResponseEntity<ResponseData> responseDescription=template.exchange("http://MovieDescription-Service/getMovieDescription", HttpMethod.POST, httpEntity, ResponseData.class);
		ResponseData responseDescription=(ResponseData)descriptionService.callMovieDescriptionService();		
		ResponseData responseRating=(ResponseData)ratingServiceCallHelper.callRatingService();
		responseData.setListMovie(responseDescription.getListMovie());
		responseData.setRatingList(responseRating.getRatingList());
		
		//		System.out.println("response from MS:"+i);
		return responseData;
	}
	
	@RequestMapping("/getData")
	public ResponseData getData()
	{
//		String header="this is header for description service";
//		String body="this is body for description service";
//		ResponseData responseDescription=movieDescriptionFeignProxy.getDescription();
		ResponseData responseDescription=zullApiGateWayFeignProxy.getDescription();
		ResponseData responseRating=zullApiGateWayFeignProxy.getRating();
		responseData.setRatingList(responseRating.getRatingList());
		responseData.setListMovie(responseDescription.getListMovie());
		return responseData;
	}
	
//	public ResponseData getFallBackMovies()
//	{
//		ResponseData responseData= new ResponseData();
//		System.out.println("fallback method ran");
//		return responseData;
//	}
	
//	public List<Movie> listMovie getMovieList()
//	{
//		
//	}
	
	
//	@Value("${db.conf.name}")
	String confName;
	
//	@Value("${spring.value}")
	String messageValue;
	@RequestMapping("/getDetails")
	public String getDetails()
	{
		return confName+" message value "+messageValue;
	}

}
