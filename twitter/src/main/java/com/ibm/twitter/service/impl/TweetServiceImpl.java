package com.ibm.twitter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.twitter.entity.Tweet;
import com.ibm.twitter.repo.TweetRepo;
import com.ibm.twitter.service.TweetService;

@Service
public class TweetServiceImpl implements TweetService {
	
	
	@Autowired
	TweetRepo tweetRepo;
	
	
	public List<Tweet> findByUserId(int id){
		return tweetRepo.findByUserId(id);
	}

	@Override
	public Tweet findById(int id) {
		return tweetRepo.findById(id).get();
	}

	@Override
	public void save(Tweet tweet) {
		tweetRepo.save(tweet);

	}

	@Override
	public void put(Tweet tweet) {
		tweetRepo.save(tweet);

	}

	@Override
	public void deleteById(int id) {
		tweetRepo.deleteById(id);

	}

}
