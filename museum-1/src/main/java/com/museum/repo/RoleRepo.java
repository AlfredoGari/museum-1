package com.museum.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.museum.domain.Role;

public interface RoleRepo extends JpaRepository<Role, Long>{
	
	Role findByName(String name);

}
