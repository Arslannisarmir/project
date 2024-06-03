package com.ibm.twitter.service;

import com.ibm.twitter.entity.Post;


public interface PostService {
	
	Post findById(int id);
	void save(Post post);
	void put(Post post);
	void deleteById(int id);
}
