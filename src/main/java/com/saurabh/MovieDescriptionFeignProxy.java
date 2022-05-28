package com.saurabh;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RibbonClient(name = "MovieDescription-Service")
//@FeignClient(name="MovieDescription-Service",url = "localhost:8097")
@FeignClient(name="MovieDescription-Service", fallback = MovieDescriptionFallback.class)
interface MovieDescriptionFeignProxy {
	
	@RequestMapping(value="/getMovieDescription", method = RequestMethod.POST)
	  ResponseData getDescription();
	
}
