package com.sk.rating.service;

import java.util.List;

import com.sk.rating.entites.Rating;

public interface RatingService {

	
	//create
	
	Rating createRating(Rating rating);
	
	//get  all rating
	
	
	List<Rating> getRating();
	
	
	
	//get all by user
	List<Rating> getratingByUsrId(String userId);
	
	
	//get all by hotel
	List<Rating> getratingByHotelId(String hotelId);
	
}
