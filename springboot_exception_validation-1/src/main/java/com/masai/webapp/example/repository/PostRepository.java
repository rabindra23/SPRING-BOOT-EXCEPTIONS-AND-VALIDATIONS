package com.masai.webapp.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.webapp.example.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

	public List<Post> findById(int pId);
}
