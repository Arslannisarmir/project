package com.ibm.twitter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.twitter.entity.User;
import com.ibm.twitter.repo.UserRepo;
import com.ibm.twitter.service.UserService;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userRepo;
	
	
	public List<User> findByNameAndPass(String name,String pass){
		return userRepo.findByNameAndPass(name, pass);
	}

	@Override
	public List<User> findAll() {
		
		return userRepo.findAll();
	}

	@Override
	public User findById(int id) {
		return userRepo.findById(id).get();
	}

	@Override
	public void save(User user) {
		userRepo.save(user);

	}

	@Override
	public void put(User user) {
		userRepo.save(user);

	}

	@Override
	public void deleteById(int id) {
		userRepo.deleteById(id);

	}


}
