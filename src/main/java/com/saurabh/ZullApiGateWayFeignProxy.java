package com.saurabh;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RibbonClient(name = "ZullApiGateWay")
@FeignClient(name = "zullapigateway", fallback = MovieDescriptionFallback.class)
public interface ZullApiGateWayFeignProxy {
	
	@RequestMapping(value="/MovieDescription-Service/getMovieDescription", method = RequestMethod.GET)
	  ResponseData getDescription();

	
	@RequestMapping(value = "RatingService/getRating", method = RequestMethod.POST)
	ResponseData getRating();
}
