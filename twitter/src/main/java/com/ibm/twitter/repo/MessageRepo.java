package com.ibm.twitter.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.twitter.entity.Message;

@Repository
public interface MessageRepo extends JpaRepository<Message,Integer>{
	
	List<Message> findByUserId(int id);

}
