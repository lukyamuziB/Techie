package com.user_frontend.service;

import com.user_frontend.domain.User;

public interface UserService {
	User findByUsername(String username);
	User findByEmail(String email);
	
	boolean checkUserExists(String username , String email);
	boolean checkUsernameExists(String useername);
	boolean checkEmailExists(String email);
	
	void save(User user);
}
