package com.museum.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class image_gallery {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long image_id;
	private String image_url;
	private String image_description;
	private Boolean is_main;
	
	public Long getImage_id() {
		return image_id;
	}
	public void setImage_id(Long image_id) {
		this.image_id = image_id;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public String getImage_description() {
		return image_description;
	}
	public void setImage_description(String image_description) {
		this.image_description = image_description;
	}
	public Boolean getIs_main() {
		return is_main;
	}
	public void setIs_main(Boolean is_main) {
		this.is_main = is_main;
	}
	
	

}
