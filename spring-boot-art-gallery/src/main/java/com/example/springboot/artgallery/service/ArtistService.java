package com.example.springboot.artgallery.service;

import com.example.springboot.artgallery.entity.Artist;

import java.util.List;

public interface ArtistService {

    List<Artist> findAllArtists();

    Artist findArtistById(int theId);

    Artist findArtistByEmail(String theUsername);

    void saveArtist(Artist theArtist);

    void deleteArtistById(int theId);
}
