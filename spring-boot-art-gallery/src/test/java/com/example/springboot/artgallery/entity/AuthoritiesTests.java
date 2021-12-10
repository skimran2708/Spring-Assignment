package com.example.springboot.artgallery.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class AuthoritiesTests {

    @Test
    void usernameAuthority_Test() {
        Authorities authorities = new Authorities();
        authorities.setUsername("jack@artist.com");
        assertEquals("jack@artist.com", authorities.getUsername());
    }

    @Test
    void authority_Test() {
        Authorities authorities = new Authorities();
        authorities.setAuthority("ROLE_ARTIST");
        assertEquals("ROLE_ARTIST", authorities.getAuthority());
    }

    @Test
    void toStringAuthorities_ConvertsToString() {
        assertFalse(new Authorities().toString().contains("@$"));
    }
}
