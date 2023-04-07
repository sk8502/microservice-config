package com.sk.rating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sk.rating.entites.Rating;
import com.sk.rating.service.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingControllers {

	@Autowired
	private RatingService ratingService;

	@PostMapping
	public ResponseEntity<Rating> create(@RequestBody Rating rating) {

		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.createRating(rating));

	}

	@GetMapping
	public ResponseEntity<List<Rating>> getAll() {

		return ResponseEntity.ok(ratingService.getRating());

	}

	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId) {

		return ResponseEntity.ok(ratingService.getratingByUsrId(userId));

	}

	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId) {

		return ResponseEntity.ok(ratingService.getratingByHotelId(hotelId));

	}
}
