package com.example.springboot.artgallery.service;

import com.example.springboot.artgallery.dao.ArtworkRepository;
import com.example.springboot.artgallery.entity.Artwork;
import com.example.springboot.artgallery.exception.MyException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest
class ArtworkServiceTests {

    @Autowired
    private ArtworkService artworkService;

    @MockBean
    private ArtworkRepository artworkRepository ;

    @Test
    void findArtistById_getArtworkWithId() {
        Artwork artwork = new Artwork(1,"Painting","1780");
        Optional<Artwork> artworkById = Optional.of(artwork);
        when(artworkRepository.findById(1)).thenReturn(artworkById);
        assertEquals(artworkService.findArtworkById(1),artwork);
    }

    @Test
    void findArtworkById_exceptionTest() {
        Exception exception = assertThrows(MyException.class, () -> artworkService.findArtworkById(2));
        String expectedMessage = "Did not find Artwork id - 2";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage,actualMessage);
    }

    @Test
    void save_saveArtwork() {
        Artwork artwork = new Artwork("Painting","1780");
        artworkService.saveArtwork(artwork);
        verify(artworkRepository,times(1)).save(artwork);
    }

    @Test
    void delete_deleteArtworkWithId() {
        artworkService.deleteArtworkById(1);
        verify(artworkRepository,times(1)).deleteById(1);
    }
}
