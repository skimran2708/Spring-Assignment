package com.example.springboot.artgallery.dto;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UsersDtoTests {

    @Test
    void usersUsername_Test() {
        UsersDto usersDto = new UsersDto();
        usersDto.setUsername("jack@artist.com");
        assertEquals("jack@artist.com", usersDto.getUsername());
    }

    @Test
    void password_Test() {
        UsersDto usersDto = new UsersDto();
        usersDto.setPassword("abcdef12345");
        assertEquals("abcdef12345", usersDto.getPassword());
    }

    @Test
    void enabled_Test() {
        UsersDto usersDto = new UsersDto();
        usersDto.setEnabled((short) 1);
        assertEquals(1, usersDto.getEnabled());
    }

    @Test
    void usersDtoConstructor_Test() {
        UsersDto usersDto = new UsersDto("jack@artist.com", "abcdef12345", (short) 1);
        assertEquals("jack@artist.com",usersDto.getUsername());
    }
}
