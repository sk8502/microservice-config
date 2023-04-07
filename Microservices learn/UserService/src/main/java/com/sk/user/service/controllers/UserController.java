package com.sk.user.service.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sk.user.service.UserService.UserService;
import com.sk.user.service.entity.User;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	 private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class.getName());
	   
	

	//create
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		
	User user1=	userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}
	
	int retrycount=1;
	@GetMapping("/{userID}")
//	@CircuitBreaker(name="ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
//	@Retry(name="ratingHotelService",fallbackMethod = "ratingHotelFallback")
	@RateLimiter(name="userRateLimiter",fallbackMethod = "ratingHotelFallback")
	public ResponseEntity<User> getSingleUser(@PathVariable String userID){
		LOGGER.info("retry count :{}" + retrycount);
		retrycount++;
		User user2=userService.getUser(userID);
		return ResponseEntity.ok(user2);
		
		
	}

	//rating fallback method for circuit breaker
	public ResponseEntity<User> ratingHotelFallback(String userID,Exception ex){
		//LOGGER.info("the fall back is excuted becuse servcie is dowan:" +ex.getMessage());
		
		 User user = User.builder()
	                .email("dummy@gmail.com")
	                .name("Dummy")
	                .about("This user is created dummy because some service is down")
	                .userId("141234")
	                .build();
	
	
		
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUser(){
		List<User> user3=this.userService.getAllUser();
		
		return ResponseEntity.ok(user3);
		
	}
	
}
