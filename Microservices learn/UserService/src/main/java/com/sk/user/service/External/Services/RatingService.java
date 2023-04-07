package com.sk.user.service.External.Services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sk.user.service.entity.Rating;

@FeignClient(name="RATING-SERVICE")
public interface RatingService {

	@PostMapping("/rating")
	public Rating createRating(Rating values);
	
	
	
	//update
	
	
	//delete
	@DeleteMapping("/rating/{ratingId}")
	public void deletedArting(@PathVariable String ratingId);
	
}
