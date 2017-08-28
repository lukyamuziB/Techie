package com.user_frontend.DAO;

import org.springframework.data.repository.CrudRepository;

import com.user_frontend.domain.User;

public interface UserDao extends CrudRepository<User, Long> {
	User findByUsername(String username);
	User findByEmail(String email);
}
