package com.museum.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.museum.domain.User;

public interface UserRepo extends JpaRepository<User, Long>{
	
	User findByUsername(String username);
	
}
