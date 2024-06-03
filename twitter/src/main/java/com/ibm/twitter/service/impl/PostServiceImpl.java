package com.ibm.twitter.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.twitter.entity.Post;
import com.ibm.twitter.repo.PostRepo;
import com.ibm.twitter.service.PostService;


@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	PostRepo postRepo;
	
	private final String FOLDER_PATH="C:\\Users\\KoustuvMishra\\Desktop\\images\\";
	
	 public byte[] downloadImageFromFileSystem(String name) throws IOException {
		 
	        Optional<Post> postData = postRepo.findByImage(name);

	        String filePath=FOLDER_PATH+postData.get().getUserId()+"\\"+postData.get().getImage();
	        
	        byte[] images = Files.readAllBytes(new File(filePath).toPath());
	        return images;
	    }
	
	public List<Post> findByUserId(int userId){
		return postRepo.findByUserId(userId);
	}

	@Override
	public void save(Post post) {
		postRepo.save(post);
		
	}

	@Override
	public void put(Post post) {
		postRepo.save(post);
		
	}

	@Override
	public void deleteById(int id) {
		postRepo.deleteById(id);
		
	}

	@Override
	public Post findById(int id) {
		return postRepo.findById(id).get();
	}
	

}
