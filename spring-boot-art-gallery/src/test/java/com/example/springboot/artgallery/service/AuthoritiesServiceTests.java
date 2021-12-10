package com.example.springboot.artgallery.service;

import com.example.springboot.artgallery.dao.AuthoritiesRepository;
import com.example.springboot.artgallery.entity.Authorities;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
class AuthoritiesServiceTests {

    @Autowired
    private AuthoritiesService authoritiesService;

    @MockBean
    private AuthoritiesRepository authoritiesRepository;

    @Test
    void save_saveAuthorities() {
        Authorities authorities = new Authorities("jack@artist.com","ROLE_ARTIST");
        authoritiesService.save(authorities);
        verify(authoritiesRepository,times(1)).save(authorities);
    }
}
