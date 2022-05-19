package com.museum.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.museum.domain.Item;

public interface ItemRepo extends JpaRepository<Item, Long>{

	
	
}
