package com.sk.hotel.service;

import java.util.List;

import com.sk.hotel.entity.Hotel;

public interface HotelServices {

	//create
	Hotel create(Hotel hotel);
	//getall
	List<Hotel> getAll();
	
	//get singlke
	Hotel get(String id);
	

}
