package com.example.springboot.artgallery.service;

import com.example.springboot.artgallery.entity.Artist;
import com.example.springboot.artgallery.entity.Users;

import java.util.List;

public interface ArtistService {

    public List<Artist> findAllArtists();

    public Artist findArtistById(int theId);

    public Artist findArtistByEmail(String theUsername);

    public Artist saveArtist(Artist theArtist);

    public void deleteArtistById(int theId);
}
