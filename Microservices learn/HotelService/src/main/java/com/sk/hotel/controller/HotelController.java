package com.sk.hotel.controller;

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

import com.sk.hotel.entity.Hotel;
import com.sk.hotel.service.HotelServices;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	private HotelServices hotelServices;
	
	//create
	@PostMapping
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelServices.create(hotel));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Hotel> createHotel(@PathVariable String id){
		
		return ResponseEntity.status(HttpStatus.OK).body(hotelServices.get(id));
	}
	
	public ResponseEntity<List<Hotel>> getAllHotel(){
		return ResponseEntity.ok(hotelServices.getAll());
	}
	
	
}
