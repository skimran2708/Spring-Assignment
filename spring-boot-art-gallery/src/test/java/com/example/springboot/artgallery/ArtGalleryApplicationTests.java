package com.example.springboot.artgallery;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.example.springboot.artgallery.dao.ArtistRepository;
import com.example.springboot.artgallery.dao.ArtworkRepository;
import com.example.springboot.artgallery.entity.Artist;
import com.example.springboot.artgallery.entity.Artwork;
import com.example.springboot.artgallery.service.ArtistService;

import com.example.springboot.artgallery.service.ArtworkService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
class ArtGalleryApplicationTests {

	@Autowired
	private ArtistService artistService;

	@Autowired
	private ArtworkService artworkService;

	@MockBean
	private ArtistRepository artistRepository;

	@MockBean
	private ArtworkRepository artworkRepository;

	@Test
	void save_saveArtist() {
		Artist artist = new Artist("Jack", "Andrew", "jack@artist.com", "39", "USA", "Contemporary");
		when(artistRepository.save(artist)).thenReturn(artist);
		assertEquals(artist, artistService.saveArtist(artist));
	}

	@Test
	void save_saveArtwork() {
		Artwork artwork = new Artwork("Painting","1780");
		when(artworkRepository.save(artwork)).thenReturn(artwork);
		assertEquals(artwork, artworkService.saveArtwork(artwork));
	}

	@Test
	void findAll_getAllArtists() {
		when(artistRepository.findAll()).thenReturn(Stream.of(
				new Artist("Kunal", "Sharma", "kunal@artist.com", "39", "USA", "Contemporary"),
				new Artist("Pavan", "Kumar", "pavan@artist.com", "28", "Italy", "Cubism")
		).collect(Collectors.toList()));
		assertEquals(2,artistService.findAllArtists().size());
	}

	@Test
	void findById_getArtistWithId() {
		Artist artist = new Artist(1,"Jack", "Andrew", "jack@artist.com", "39", "USA", "Contemporary");
		Optional<Artist> artistById = Optional.of(artist);
		when(artistRepository.findById(1)).thenReturn(artistById);
		assertEquals(artistService.findArtistById(1),artist);
	}

	@Test
	void findByEmail_getArtistWithEmail() {
		Artist artist = new Artist("Jack", "Andrew", "jack@artist.com", "39", "USA", "Contemporary");
		Optional<Artist> artistByEmail = Optional.of(artist);
		when(artistRepository.findByEmail("jack@artist.com")).thenReturn(artistByEmail);
		assertEquals(artistService.findArtistByEmail("jack@artist.com"),artist);
	}


}
