package com.sk.user.service.UserService.Impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sk.user.service.Exception.ResourceNotFoundException;
import com.sk.user.service.External.Services.HotelService;
import com.sk.user.service.UserService.UserService;
import com.sk.user.service.entity.Hotel;
import com.sk.user.service.entity.Rating;
import com.sk.user.service.entity.User;
import com.sk.user.service.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private HotelService hotelService;
	
	private org.slf4j.Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User saveUser(User user) {
		String ranbdomId = UUID.randomUUID().toString();
		user.setUserId(ranbdomId);
		return userRepository.save(user);

	}

	@Override
	public List<User> getAllUser() {

		return userRepository.findAll();
	}

	@Override
	public User getUser(String userId) {
		
	User user= userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User with given id is not found"+userId));
	
	
	Rating[] ratingofuser=restTemplate.getForObject("http://RATING-SERVICE/rating/users/"+user.getUserId(), Rating[].class);

	List<Rating> ratings=Arrays.stream(ratingofuser).toList();
   List<Rating> ratinglist=ratings.stream().map(rating -> {  
	   System.out.println(rating.getHotelId());
	//ResponseEntity<Hotel>   forentry= restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
	   Hotel hotel=hotelService.getHotel(rating.getHotelId());
	 //  logger.info("responce status code: {}",forentry.getStatusCode());
	   
	   rating.setHotel(hotel);
	   return rating;
   }).collect(Collectors.toList());
	user.setRating(ratinglist);
	
	return user;
	}

}
