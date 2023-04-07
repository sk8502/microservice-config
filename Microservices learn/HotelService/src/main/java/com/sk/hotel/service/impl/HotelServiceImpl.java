package com.sk.hotel.service.impl;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sk.hotel.entity.Hotel;
import com.sk.hotel.exception.ResourceNotFoundException;
import com.sk.hotel.repository.HotelRepository;
import com.sk.hotel.service.HotelServices;


@Service
public class HotelServiceImpl  implements HotelServices{

	@Autowired
	private HotelRepository hotelRepository;
	
	
	@Override
	public Hotel create(Hotel hotel) {
		String randoma=UUID.randomUUID().toString();
		hotel.setId(randoma);
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		// TODO Auto-generated method stub
		return hotelRepository.findAll();
	}

	@Override
	public Hotel get(String id) {
		// TODO Auto-generated method stub
		return hotelRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("hotel with given id is not found"+id));
	}
	
	

}
