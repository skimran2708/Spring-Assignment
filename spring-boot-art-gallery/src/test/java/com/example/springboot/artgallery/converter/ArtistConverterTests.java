package com.example.springboot.artgallery.converter;

import com.example.springboot.artgallery.dto.ArtistDto;
import com.example.springboot.artgallery.entity.Artist;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ArtistConverterTests {

    @Test
    void entityToDto_convertsArtistEntityToArtistDto() {
        Artist artist = new Artist(1,"Jack", "Smith", "jack@artist.com", "39", "USA", "Contemporary");
        ArtistDto artistDto = new ArtistConvertor().entityToDto(artist);
        assertEquals("Jack",artistDto.getFirstName());
    }

    @Test
    void DtoToEntity_convertsArtistDtoToArtistEntity() {
        ArtistDto artistDto = new ArtistDto(1,"Jack", "Smith", "jack@artist.com", "39", "USA", "Contemporary");
        Artist artist = new ArtistConvertor().dtoToEntity(artistDto);
        assertEquals("Jack",artist.getFirstName());
    }

    @Test
    void entityToDto_convertsArtistEntityLisToArtistDtoList() {
        Artist artist1 = new Artist("Kunal", "Sharma", "kunal@artist.com", "39", "USA", "Contemporary");
        Artist artist2 = new Artist("Pavan", "Kumar", "pavan@artist.com", "28", "Italy", "Cubism");
        List<Artist> artistList = new ArrayList<>();
        artistList.add(artist1);
        artistList.add(artist2);
        List<ArtistDto> artistDtoList = new ArtistConvertor().entityToDto(artistList);
        assertEquals(2,artistDtoList.size());
    }

    @Test
    void dtoToEntity_convertsArtistDtoListToArtistEntityList() {
        ArtistDto artistDto1 = new ArtistDto(1,"Kunal", "Sharma", "kunal@artist.com", "39", "USA", "Contemporary");
        ArtistDto artistDto2 = new ArtistDto(2,"Pavan", "Kumar", "pavan@artist.com", "28", "Italy", "Cubism");
        List<ArtistDto> artistDtoList = new ArrayList<>();
        artistDtoList.add(artistDto1);
        artistDtoList.add(artistDto2);
        List<Artist> artistList = new ArtistConvertor().dtoToEntity(artistDtoList);
        assertEquals(2,artistList.size());
    }
}
