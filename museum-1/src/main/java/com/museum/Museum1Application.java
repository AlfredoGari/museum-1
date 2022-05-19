package com.museum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Museum1Application {

	public static void main(String[] args) {
		SpringApplication.run(Museum1Application.class, args);
	}
	
	@Bean
	@Autowired
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
