package com.example.springboot.artgallery;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ArtGalleryApplicationTests {

	@Test
	void contextLoads() {
		String[] args = new String[0];
		ArtGalleryApplication.main(args);
		assertEquals(args,ArtGalleryApplication.args2);
	}
}
