package com.example.springboot.artgallery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ArtGalleryApplication {

	static String[] args2;

	public static void main(String[] args) {
		args2 = args;
		SpringApplication.run(ArtGalleryApplication.class, args);
	}

}
