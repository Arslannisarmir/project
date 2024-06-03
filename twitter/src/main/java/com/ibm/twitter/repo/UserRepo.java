package com.ibm.twitter.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.twitter.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	
	public List<User> findByNameAndPass(String name,String pass);

}
