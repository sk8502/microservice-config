package com.sk.user.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sk.user.service.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

}
