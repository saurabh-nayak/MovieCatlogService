package com.saurabh;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "RatingService", fallback =MovieRatingFallBack.class)
@RibbonClient(name = "RatingService")
public interface MovieRatingFeignProxy {
	
	@RequestMapping(value = "/getRating", method = RequestMethod.GET)
	ResponseData getRating();

}
