package com.example.springboot.artgallery.converter;

import com.example.springboot.artgallery.dto.ArtworkDto;
import com.example.springboot.artgallery.entity.Artwork;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ArtworkConverterTests {

    @Test
    void entityToDto_convertsArtworkEntityToArtworkDto() {
        Artwork artwork = new Artwork(1,"Painting","1780");
        ArtworkDto artworkDto = new ArtworkConverter().entityToDto(artwork);
        assertEquals("Painting",artworkDto.getTitle());
    }

    @Test
    void DtoToEntity_convertsArtworkDtoToArtworkEntity() {
        ArtworkDto artworkDto = new ArtworkDto(1,"Painting","1780");
        Artwork artwork = new ArtworkConverter().dtoToEntity(artworkDto);
        assertEquals("Painting",artwork.getTitle());
    }

    @Test
    void entityToDto_convertsArtworkEntityListToArtworkDtoList() {
        Artwork artwork1 = new Artwork(1,"Painting","1780");
        Artwork artwork2 = new Artwork(2,"Sunflower","1880");
        List<Artwork> artworkList = new ArrayList<>();
        artworkList.add(artwork1);
        artworkList.add(artwork2);
        List<ArtworkDto> artworkDtoList = new ArtworkConverter().entityToDto(artworkList);
        assertEquals(2,artworkDtoList.size());
    }

    @Test
    void dtoToEntity_convertsArtworkDtoListToArtworkEntityList() {
        ArtworkDto artworkDto1 = new ArtworkDto(1,"Painting","1780");
        ArtworkDto artworkDto2 = new ArtworkDto(2,"Sunflower","1880");
        List<ArtworkDto> artworkDtoList = new ArrayList<>();
        artworkDtoList.add(artworkDto1);
        artworkDtoList.add(artworkDto2);
        List<Artwork> artworkList = new ArtworkConverter().dtoToEntity(artworkDtoList);
        assertEquals(2,artworkList.size());
    }
}
