package com.ibm.twitter.controller;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.twitter.entity.Post;
import com.ibm.twitter.entity.User;
import com.ibm.twitter.service.impl.PostServiceImpl;
import com.ibm.twitter.service.impl.UserServiceImpl;

@RestController
@CrossOrigin("*")
public class PostController {
	
	@Autowired
	UserServiceImpl userService;
	
	@Autowired
	PostServiceImpl postService;
	
	@Autowired
	ObjectMapper mapper;
	
	 private final String FOLDER_PATH="C:\\Users\\KoustuvMishra\\Desktop\\images\\";
	 
	 private final Path root = Paths.get(FOLDER_PATH);
	 
	 private String contentType;
	 
	 
	
	
	@GetMapping("/post/{id}")
	List<Post> findByUserId(@PathVariable int id){
//		List<User> dbUser= userService.findByNameAndPass(user.getName(), user.getPass());
		return postService.findByUserId(id);
		
	}
	
	@PostMapping("/post")
	public ResponseEntity<?> savePost(
			@RequestParam("captions") String captions,
			@RequestParam("title") String title,
			@RequestParam("postedBy") String postedBy,
			@RequestParam("userId") int userId,
			@RequestParam("file")MultipartFile file	) throws IllegalStateException, IOException{

		Post post=new Post(captions,title,postedBy,userId);
		

		String filePath=FOLDER_PATH+userId+"\\"+file.getOriginalFilename();
		
		contentType=file.getContentType();
		
		Files.copy(file.getInputStream(), Paths.get(FOLDER_PATH +userId+ "\\" + file.getOriginalFilename()));
		
		post.setImage(file.getOriginalFilename());
		
		postService.save(post);
		
		return ResponseEntity.ok("done");
	}
	
	@PostMapping("/edit/{id}")
	public ResponseEntity<?> editPost(@PathVariable int id,
			@RequestParam("captions") String captions,
			@RequestParam("title") String title,
			@RequestParam("postedBy") String postedBy,
			@RequestParam("userId") int userId,
			@RequestParam("file")MultipartFile file	) throws IllegalStateException, IOException{

		Post post=new Post(captions,title,postedBy,userId);
		post.setId(id);
		
		
		String filePath=FOLDER_PATH+file.getOriginalFilename();
		
		contentType=file.getContentType();
		
		String filePathString=FOLDER_PATH + "\\" + file.getOriginalFilename();
		
		File f = new File(filePathString);
		
		if(!f.exists()) {
			Files.copy(file.getInputStream(), Paths.get(filePathString));
		}
		
		
		post.setImage(file.getOriginalFilename());
		
		postService.save(post);
		
		return ResponseEntity.ok("done");
	}
	
	
	@GetMapping("/image/{fileName}")
	public ResponseEntity<?> downloadImageFromFileSystem(@PathVariable String fileName) throws IOException {
		
	
		
		
		byte[] imageData=postService.downloadImageFromFileSystem(fileName);
		
		
		
//		HttpHeaders responseHeaders=new HttpHeaders();
//		responseHeaders.setContentType(MediaType.IMG_PNG);
		
		if(fileName.contains(".jpg")) {
			
			return ResponseEntity
					.status(HttpStatus.OK)
					.contentType(MediaType.IMAGE_JPEG)
					.body(imageData);
			
			
		}
		else if(fileName.contains(".png")) {
		return ResponseEntity
				.status(HttpStatus.OK)
				.contentType(MediaType.IMAGE_PNG)
				.body(imageData);
			
		}
		else if(fileName.contains(".jpeg")) {
			return ResponseEntity
					.status(HttpStatus.OK)
					.contentType(MediaType.IMAGE_JPEG)
					.body(imageData);
				
			}
		else {
			return ResponseEntity
					.status(HttpStatus.OK)
					.contentType(MediaType.ALL)
					.body(imageData);
		}


	}
	
	
	@DeleteMapping("/delete/{id}")
	void deleteById(@PathVariable int id) throws IOException {
		
		Post post = postService.findById(id);
		
		Path filePath=root.resolve(post.getUserId()+"\\"+post.getImage());
		System.out.println(filePath);
		Files.deleteIfExists(filePath);
		postService.deleteById(id);
		
	}
	
	
	
}

