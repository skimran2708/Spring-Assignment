package com.example.springboot.artgallery.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class ArtistTests {

    @Test
    void artistId_Test() {
        Artist artist=new Artist();
        artist.setId(1);
        assertEquals(1,artist.getId());
    }

    @Test
    void firstName_Test() {
        Artist artist=new Artist();
        artist.setFirstName("Jack");
        assertEquals("Jack",artist.getFirstName());
    }

    @Test
    void lastName_Test() {
        Artist artist=new Artist();
        artist.setLastName("Smith");
        assertEquals("Smith",artist.getLastName());
    }

    @Test
    void email_Test() {
        Artist artist=new Artist();
        artist.setEmail("jack@artist.com");
        assertEquals("jack@artist.com",artist.getEmail());
    }

    @Test
    void age_Test() {
        Artist artist=new Artist();
        artist.setAge("39");
        assertEquals("39",artist.getAge());
    }

    @Test
    void birthPlace_Test() {
        Artist artist=new Artist();
        artist.setBirthPlace("USA");
        assertEquals("USA",artist.getBirthPlace());
    }

    @Test
    void artStyle_Test() {
        Artist artist=new Artist();
        artist.setArtStyle("Contemporary");
        assertEquals("Contemporary",artist.getArtStyle());
    }

    @Test
    void artworkArtist_Test() {
        Artist artist=new Artist();
        Artwork theArtwork1 = new Artwork(1,"Painting","1780");
        Artwork theArtwork2 = new Artwork(2,"Sunflower","1880");
        List<Artwork> artwork = new ArrayList<>();
        artwork.add(theArtwork1);
        artist.setArtworks(artwork);
        artist.addArtwork(theArtwork2);
        assertEquals(2,artist.getArtworks().size());
    }

    @Test
    void addArtworkArtist_Test() {
        Artist artist = new Artist("Jack", "Smith", "jack@artist.com", "39", "USA", "Contemporary");
        Artwork artwork = new Artwork(1,"Painting","1780");
        artist.addArtwork(artwork);
        assertEquals(1,artist.getArtworks().size());
    }

    @Test
    void toStringArtist_ConvertsToString() {
        assertFalse(new Artist().toString().contains("@$"));
    }
}
