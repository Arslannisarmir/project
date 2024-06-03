package com.ibm.twitter.service;

import java.util.List;

import com.ibm.twitter.entity.Tweet;


public interface TweetService {

	Tweet findById(int id);
	void save(Tweet tweet);
	void put(Tweet tweet);
	void deleteById(int id);
	
}
