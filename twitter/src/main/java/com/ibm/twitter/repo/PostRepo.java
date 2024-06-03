package com.ibm.twitter.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.twitter.entity.Post;
import com.ibm.twitter.entity.User;


@Repository
public interface PostRepo extends JpaRepository<Post, Integer> {
	
	public List<Post> findByUserId(int userId);
	Optional<Post> findByImage(String fileName);

}
