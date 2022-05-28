package com.saurabh;

import java.util.Arrays;

import org.springframework.stereotype.Component;

@Component
public class MovieRatingFallBack implements MovieRatingFeignProxy {

	@Override
	public ResponseData getRating() {
		// TODO Auto-generated method stub
		ResponseData responseData= new ResponseData();
		responseData.setRatingList(Arrays.asList(new MovieRating(101,3),new MovieRating(102, 5)));
		return responseData;
	}
	

}
