package com.example.springboot.artgallery.service;


import com.example.springboot.artgallery.entity.Users;


public interface UsersService {

    Users findByUsername(String theUsername);

    void save(Users theUser);

    void deleteByUsername(String theUsername);
}
