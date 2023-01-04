package com.masai.webapp.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.webapp.example.entity.Post;
import com.masai.webapp.example.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService {
	@Autowired
	PostRepository repository;

	@Override
	public List<Post> addPost(Post post) {
		repository.save(post);
		return repository.findAll();
	}

	@Override
	public boolean deletePost(int pId) {
		repository.deleteById(pId);
		return true;
	}

	@Override
	public List<Post> getPosts() {
		return repository.findAll();
	}

	@Override
	public Post getPost(int pId) {
		return repository.findById(pId).get(pId);
	}

}
