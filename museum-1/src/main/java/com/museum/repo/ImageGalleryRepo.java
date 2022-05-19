package com.museum.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.museum.domain.image_gallery;

public interface ImageGalleryRepo extends JpaRepository<image_gallery, Long>{
	
	

}
