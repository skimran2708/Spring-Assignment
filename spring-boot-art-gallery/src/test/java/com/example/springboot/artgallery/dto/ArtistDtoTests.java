package com.example.springboot.artgallery.dto;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ArtistDtoTests {

    @Test
    void artistId_Test() {
        ArtistDto artistDto=new ArtistDto();
        artistDto.setId(1);
        assertEquals(1,artistDto.getId());
    }

    @Test
    void firstName_Test() {
        ArtistDto artistDto=new ArtistDto();
        artistDto.setFirstName("Jack");
        assertEquals("Jack",artistDto.getFirstName());
    }

    @Test
    void lastName_Test() {
        ArtistDto artistDto=new ArtistDto();
        artistDto.setLastName("Smith");
        assertEquals("Smith",artistDto.getLastName());
    }

    @Test
    void email_Test() {
        ArtistDto artistDto=new ArtistDto();
        artistDto.setEmail("jack@artist.com");
        assertEquals("jack@artist.com",artistDto.getEmail());
    }

    @Test
    void age_Test() {
        ArtistDto artistDto=new ArtistDto();
        artistDto.setAge("39");
        assertEquals("39",artistDto.getAge());
    }

    @Test
    void birthPlace_Test() {
        ArtistDto artistDto=new ArtistDto();
        artistDto.setBirthPlace("USA");
        assertEquals("USA",artistDto.getBirthPlace());
    }

    @Test
    void artStyle_Test() {
        ArtistDto artistDto=new ArtistDto();
        artistDto.setArtStyle("Contemporary");
        assertEquals("Contemporary",artistDto.getArtStyle());
    }

    @Test
    void artistDtoConstructor_Test() {
        ArtistDto artistDto =new ArtistDto(1,"Jack", "Smith", "jack@artist.com", "39", "USA", "Contemporary");
        assertEquals("Jack",artistDto.getFirstName());
    }
}
