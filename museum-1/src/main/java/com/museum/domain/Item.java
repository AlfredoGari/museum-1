package com.museum.domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Item {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String room_name;
	private String title;
	private String introduction;
	private String youtube_links;
	private String tags;
	private String external_links;
	private String lat;
	private String longi;
	private String audio_url;
	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<image_gallery> ig= new ArrayList<>();
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRoom_name() {
		return room_name;
	}
	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getYoutube_links() {
		return youtube_links;
	}
	public void setYoutube_links(String youtube_links) {
		this.youtube_links = youtube_links;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getExternal_links() {
		return external_links;
	}
	public void setExternal_links(String external_links) {
		this.external_links = external_links;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLongi() {
		return longi;
	}
	public void setLongi(String longi) {
		this.longi = longi;
	}
	public String getAudio_url() {
		return audio_url;
	}
	public void setAudio_url(String audio_url) {
		this.audio_url = audio_url;
	}
	public Collection<image_gallery> getIg() {
		return ig;
	}
	public void setIg(Collection<image_gallery> ig) {
		this.ig = ig;
	}
	
	
	

}
