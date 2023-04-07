package com.sk.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sk.hotel.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String> {

}
