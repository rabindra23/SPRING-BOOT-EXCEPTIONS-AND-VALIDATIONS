package com.masai.webapp.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.webapp.example.entity.Post;
import com.masai.webapp.example.exception.MessageLimitExceeded;
import com.masai.webapp.example.exception.UsernameLength;
import com.masai.webapp.example.service.PostService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class MyController {

	@Autowired
	PostService service;
	
	@PostMapping("/posts")
	public ResponseEntity<?> createPost(@Valid @RequestBody Post post){
		if(post.getMessage().length()>100) {
			throw new MessageLimitExceeded("Message limit is 100 characters");
		}
		else if(post.getUsername().length()<8) {
			throw new UsernameLength("Username should be minimum 8 characters long");

		}
		else {
			List<Post> posts = service.addPost(post);
			return new ResponseEntity<List<Post>>(posts,HttpStatus.CREATED);
		}
		
	}
	
	@GetMapping("/posts")
	public List<Post> getBook(){
		return service.getPosts();
	}
	
//	@ExceptionHandler(IllegalArgumentException.class)
//	public String myExceptionHandler(IllegalArgumentException ex) {
//		System.out.println("In my Exception Handler");
//		return ex.getMessage();
//	}
}
