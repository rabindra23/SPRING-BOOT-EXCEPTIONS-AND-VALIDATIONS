package com.masai.webapp.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.webapp.example.entity.Post;

@Service
public interface PostService {

	public List<Post> addPost(Post post);
	public boolean deletePost(int pId);
	public List<Post> getPosts();
	public Post getPost(int pId);
}
