package com.example.springboot.artgallery.dto;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ArtworkDtoTests {

    @Test
    void artworkId_Test() {
        ArtworkDto artworkDto = new ArtworkDto();
        artworkDto.setId(1);
        assertEquals(1, artworkDto.getId());
    }

    @Test
    void title_Test() {
        ArtworkDto artworkDto = new ArtworkDto();
        artworkDto.setTitle("Painting");
        assertEquals("Painting",artworkDto.getTitle());
    }

    @Test
    void year_Test() {
        ArtworkDto artworkDto = new ArtworkDto();
        artworkDto.setYear("1780");
        assertEquals("1780",artworkDto.getYear());
    }

    @Test
    void artworkDtoConstructor_Test() {
        ArtworkDto artworkDto = new ArtworkDto(1,"Painting","1780");
        assertEquals("Painting",artworkDto.getTitle());
    }
}
