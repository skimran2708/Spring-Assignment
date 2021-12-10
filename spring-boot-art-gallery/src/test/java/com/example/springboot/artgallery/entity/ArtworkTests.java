package com.example.springboot.artgallery.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class ArtworkTests {

    @Test
    void artworkId_Test() {
        Artwork artwork = new Artwork();
        artwork.setId(1);
        assertEquals(1, artwork.getId());
    }

    @Test
    void title_Test() {
        Artwork artwork = new Artwork();
        artwork.setTitle("Painting");
        assertEquals("Painting",artwork.getTitle());
    }

    @Test
    void year_Test() {
        Artwork artwork = new Artwork();
        artwork.setYear("1780");
        assertEquals("1780",artwork.getYear());
    }

    @Test
    void toStringArtwork_ConvertsToString() {
        assertFalse(new Artwork().toString().contains("@$"));
    }
}
