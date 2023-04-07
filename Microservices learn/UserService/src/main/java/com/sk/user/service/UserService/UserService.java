package com.sk.user.service.UserService;

import java.util.List;

import com.sk.user.service.entity.User;

public interface UserService {

	
	User saveUser(User user); 
	
	List<User> getAllUser();
	
	User getUser(String userId);
}
