package com.ibm.twitter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.twitter.entity.Tweet;
import com.ibm.twitter.service.impl.TweetServiceImpl;

@RestController
@CrossOrigin("*")
public class TweetController {
	
	@Autowired
	TweetServiceImpl tweetService;
	
	
	@PostMapping("/tweet")
	public ResponseEntity<?> saveTweet(@RequestParam("text") String text,@RequestParam("userId") int userId){
		Tweet tweet = new Tweet(text,userId);
		tweetService.save(tweet);
		return ResponseEntity.ok("done");
	}
	
	@PostMapping("/tweet/edit")
	public ResponseEntity<?> saveTweet(@RequestParam("id") int id,@RequestParam("text") String text,@RequestParam("userId") int userId){
		Tweet tweet = new Tweet(id,text,userId);
		tweetService.save(tweet);
		return ResponseEntity.ok("done");
	}
		
	@GetMapping("/tweet/{userId}")
	List<Tweet> findByUserId(@PathVariable int userId){
		return tweetService.findByUserId(userId);
	}
	
	@DeleteMapping("/tweet/{id}")
	void deleteById(@PathVariable int id) {
		tweetService.deleteById(id);
	}
}
