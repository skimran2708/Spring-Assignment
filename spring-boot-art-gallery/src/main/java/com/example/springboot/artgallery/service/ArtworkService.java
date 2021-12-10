package com.example.springboot.artgallery.service;

import com.example.springboot.artgallery.entity.Artwork;

public interface ArtworkService {

    Artwork findArtworkById(int theId);

    void saveArtwork(Artwork theArtwork);

    void deleteArtworkById(int theId);
}
