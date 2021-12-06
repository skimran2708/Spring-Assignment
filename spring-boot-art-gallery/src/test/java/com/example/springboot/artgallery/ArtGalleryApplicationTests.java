package com.example.springboot.artgallery;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import com.example.springboot.artgallery.dao.ArtistRepository;
import com.example.springboot.artgallery.dao.ArtworkRepository;
import com.example.springboot.artgallery.entity.Artist;
import com.example.springboot.artgallery.entity.Artwork;
import com.example.springboot.artgallery.service.ArtistService;

import com.example.springboot.artgallery.service.ArtworkService;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ArtGalleryApplicationTests {

	@Autowired
	private ArtistService artistService;

	@Autowired
	private ArtworkService artworkService;

	@MockBean
	private ArtistRepository artistRepository;

	@MockBean
	private ArtworkRepository artworkRepository;

	@Test
	public void save_saveArtist() {
		Artist artist = new Artist("Jack", "Andrew", "jack@artist.com", "39", "USA", "Contemporary");
		when(artistRepository.save(artist)).thenReturn(artist);
		assertEquals(artist, artistService.saveArtist(artist));
	}

	@Test
	public void save_saveArtwork() {
		Artwork artwork = new Artwork("Painting","1780");
		when(artworkRepository.save(artwork)).thenReturn(artwork);
		assertEquals(artwork, artworkService.saveArtwork(artwork));
	}

	@Test
	public void findAll_getAllArtists() {
		when(artistRepository.findAll()).thenReturn(Stream.of(
				new Artist("Kunal", "Sharma", "kunal@artist.com", "39", "USA", "Contemporary"),
				new Artist("Pavan", "Kumar", "pavan@artist.com", "28", "Italy", "Cubism")
		).collect(Collectors.toList()));
		assertEquals(2,artistService.findAllArtists().size());
	}

	@Test
	@Order(3)
	public void findByEmail_getArtistWithEmail() {
		Artist artist = new Artist("Jack", "Andrew", "jack@artist.com", "39", "USA", "Contemporary");
		Optional<Artist> artistByEmail = Optional.ofNullable(artist);
		when(artistRepository.findByEmail("jack@artist.com")).thenReturn(artistByEmail);
		assertEquals(artistService.findArtistByEmail("jack@artist.com"),artist);
	}


}
