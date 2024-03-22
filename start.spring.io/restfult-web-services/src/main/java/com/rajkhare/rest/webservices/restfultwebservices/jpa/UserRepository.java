package com.rajkhare.rest.webservices.restfultwebservices.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rajkhare.rest.webservices.restfultwebservices.user.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
