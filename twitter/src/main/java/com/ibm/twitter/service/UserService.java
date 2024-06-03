package com.ibm.twitter.service;

import java.util.List;

import com.ibm.twitter.entity.User;


public interface UserService {
	
	List<User> findAll();
	User findById(int id);
	void save(User user);
	void put(User user);
	void deleteById(int id);
}
