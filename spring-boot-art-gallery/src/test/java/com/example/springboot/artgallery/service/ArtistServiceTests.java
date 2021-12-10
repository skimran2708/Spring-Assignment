package com.example.springboot.artgallery.service;

import com.example.springboot.artgallery.dao.ArtistRepository;
import com.example.springboot.artgallery.entity.Artist;
import com.example.springboot.artgallery.exception.MyException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest
class ArtistServiceTests {

    @Autowired
    private ArtistService artistService;

    @MockBean
    private ArtistRepository artistRepository;

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
        Artist artist = new Artist(1,"Jack", "Smith", "jack@artist.com", "39", "USA", "Contemporary");
        Optional<Artist> artistById = Optional.of(artist);
        when(artistRepository.findById(1)).thenReturn(artistById);
        assertEquals(artistService.findArtistById(1),artist);
    }

    @Test
    void findById_exceptionTest() {
        Exception exception = assertThrows(MyException.class, () -> {
            artistService.findArtistById(2);
        });
        String expectedMessage = "Did not find Artist id - 2";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage,actualMessage);
    }

    @Test
    void findByEmail_getArtistWithEmail() {
        Artist artist = new Artist("Jack", "Smith", "jack@artist.com", "39", "USA", "Contemporary");
        Optional<Artist> artistByEmail = Optional.of(artist);
        when(artistRepository.findByEmail("jack@artist.com")).thenReturn(artistByEmail);
        assertEquals(artistService.findArtistByEmail("jack@artist.com"),artist);
    }

    @Test
    void findByEmail_exceptionTest() {
        Exception exception = assertThrows(MyException.class, () -> {
            artistService.findArtistByEmail("jack@artist.com");
        });
        String expectedMessage = "Did not find Artist - jack@artist.com";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage,actualMessage);
    }

    @Test
    void save_saveArtist() {
        Artist artist = new Artist("Jack", "Smith", "jack@artist.com", "39", "USA", "Contemporary");
        artistService.saveArtist(artist);
        verify(artistRepository,times(1)).save(artist);
    }

    @Test
    void deleteById_deleteArtistWithId() {
        artistService.deleteArtistById(1);
        verify(artistRepository,times(1)).deleteById(1);
    }
}
