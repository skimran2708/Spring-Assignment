package com.example.springboot.artgallery;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import com.example.springboot.artgallery.dao.ArtistRepository;
import com.example.springboot.artgallery.dao.ArtworkRepository;
import com.example.springboot.artgallery.dao.UsersRepository;
import com.example.springboot.artgallery.entity.Artist;
import com.example.springboot.artgallery.entity.Artwork;
import com.example.springboot.artgallery.entity.Users;
import com.example.springboot.artgallery.service.ArtistService;

import com.example.springboot.artgallery.service.ArtworkService;
import com.example.springboot.artgallery.service.UsersService;
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

	@Autowired
	private UsersService usersService;

	@MockBean
	private ArtistRepository artistRepository;

	@MockBean
	private ArtworkRepository artworkRepository ;

	@MockBean
	private UsersRepository usersRepository;

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

	@Test
	void save_saveArtist() {
		Artist artist = new Artist("Jack", "Andrew", "jack@artist.com", "39", "USA", "Contemporary");
		artistService.saveArtist(artist);
		verify(artistRepository,times(1)).save(artist);
	}

	@Test
	void deleteById_deleteArtistWithId() {
		Artist artist = new Artist(1,"Jack", "Andrew", "jack@artist.com", "39", "USA", "Contemporary");
		artistService.deleteArtistById(1);
		verify(artistRepository,times(1)).deleteById(1);
	}

	@Test
	void findById_getArtworkWithId() {
		Artwork artwork = new Artwork(1,"Painting","1780");
		Optional<Artwork> artworkById = Optional.of(artwork);
		when(artworkRepository.findById(1)).thenReturn(artworkById);
		assertEquals(artworkService.findArtworkById(1),artwork);
	}

	@Test
	void save_saveArtwork() {
		Artist artist = new Artist(1,"Jack", "Andrew", "jack@artist.com", "39", "USA", "Contemporary");
		Artwork artwork = new Artwork("Painting","1780");
		artist.addArtwork(artwork);
		artistService.saveArtist(artist);
		artworkService.saveArtwork(artwork);
		verify(artworkRepository,times(1)).save(artwork);
	}

	@Test
	void delete_deleteArtworkWithId() {
		Artwork artwork = new Artwork(1,"Painting","1780");
		artworkService.deleteArtworkById(1);
		verify(artworkRepository,times(1)).deleteById(1);
	}

	@Test
	void findByUsername_getUserWithEmail() {
		Users users = new Users("jack@artist.com", "abcdef123", (short) 1);
		Optional<Users> userByEmail = Optional.of(users);
		when(usersRepository.findByUsername("jack@artist.com")).thenReturn(userByEmail);
		assertEquals(usersService.findByUsername("jack@artist.com"),users);
	}

	@Test
	void save_saveUser() {
		Users users = new Users("jack@artist.com", "abcdef123", (short) 1);
		usersService.save(users);
		verify(usersRepository,times(1)).save(users);
	}

	@Test
	void delete_deleteUserWithId() {
		Users users = new Users("jack@artist.com", "abcdef123", (short) 1);
		usersService.deleteByUsername("jack@artist.com");
		verify(usersRepository,times(1)).deleteByUsername("jack@artist.com");
	}


}
