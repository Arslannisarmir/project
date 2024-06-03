package com.ibm.twitter.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.twitter.entity.Tweet;

@Repository
public interface TweetRepo extends JpaRepository<Tweet, Integer> {
	List<Tweet> findByUserId(int id);
}
