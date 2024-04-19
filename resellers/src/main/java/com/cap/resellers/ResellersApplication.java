package com.cap.resellers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class ResellersApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResellersApplication.class, args);
	}

}
