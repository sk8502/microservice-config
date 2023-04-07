package com.sk.rating.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sk.rating.entites.Rating;
import com.sk.rating.repository.RatingRepository;
import com.sk.rating.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService{

	
	@Autowired
	private RatingRepository repository;
	
	@Override
	public Rating createRating(Rating rating) {
	
		String randoma=UUID.randomUUID().toString();
		rating.setRatingId(randoma);
		return repository.save(rating);
	}

	@Override
	public List<Rating> getRating() {
		
		return repository.findAll();
	}

	@Override
	public List<Rating> getratingByUsrId(String userId) {
		
		return repository.findByUserId(userId);
	}

	@Override
	public List<Rating> getratingByHotelId(String hotelId) {
		
		return repository.findByHotelId(hotelId);
	}

	
	
}
