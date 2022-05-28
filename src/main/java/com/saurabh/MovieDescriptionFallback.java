package com.saurabh;

import java.util.Arrays;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import feign.hystrix.FallbackFactory;

@Component
 public class MovieDescriptionFallback implements MovieDescriptionFeignProxy, ZullApiGateWayFeignProxy{
	
	ResponseData responseData=new ResponseData();
	@Override
	public ResponseData getDescription() {
		
		responseData.setListMovie(Arrays.asList(new Movie(101,"aladin","that was fucking shit movie"),
				new Movie(102,"bhagam bhag", "Awesome movie")
				));
		return responseData;
	}
	
	@Override
	public ResponseData getRating() {
		// TODO Auto-generated method stub
		responseData.setRatingList(Arrays.asList(new MovieRating(101,3),new MovieRating(102, 5)));
		return responseData;
	}

//	@Override
//	public MovieCatlogFeignProxy create(Throwable cause) {
//		// TODO Auto-generated method stub
//		return new MovieCatlogFeignProxy() {
//			
//			@Override
//			public ResponseData getDescription() {
//				// TODO Auto-generated method stub
//				ResponseData responseData=new ResponseData();
//				responseData.setListMovie(Arrays.asList(new Movie(101,"aladin","that was fucking shit movie"),
//						new Movie(102,"bhagam bhag", "Awesome movie")
//						));
//				return responseData;
//			}
//		};
//	}
	
	
}
