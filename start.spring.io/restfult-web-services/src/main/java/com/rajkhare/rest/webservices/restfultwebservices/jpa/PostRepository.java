package com.rajkhare.rest.webservices.restfultwebservices.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rajkhare.rest.webservices.restfultwebservices.user.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
