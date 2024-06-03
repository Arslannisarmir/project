package com.ibm.twitter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.twitter.entity.Post;
import com.ibm.twitter.entity.User;
import com.ibm.twitter.service.UserService;
import com.ibm.twitter.service.impl.PostServiceImpl;
import com.ibm.twitter.service.impl.UserServiceImpl;


@RestController
@CrossOrigin("*")
public class UserController {
	@Autowired
	UserServiceImpl userService;
	
	@PostMapping("/login")
	ResponseEntity<User> checkLogin(@RequestBody User user ) {
		List<User> u =userService.findByNameAndPass(user.getName(), user.getPass());
		if(u.size()>0) {
			return ResponseEntity.status(HttpStatus.OK).body(u.get(0));
		}
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
	@GetMapping("/user")
	List<User> findAll()
	{
		return userService.findAll();
		
	}
	
	@GetMapping("/user/{id}")
	User findById(@PathVariable int id)
	{
		return userService.findById(id);
		
	}
	
	@PutMapping("/user")
	void update(@RequestBody User user)
	{
		userService.save(user);
		
	}
	
	
	
	@PostMapping("/user")
	void save(@RequestBody User user)
	{
		
		
		userService.save(user);
		
	}
	
	@DeleteMapping("/user/{id}")
	void deleteById(@PathVariable int id)
	{
		userService.deleteById(id);
		
	}
	
	
	

}

