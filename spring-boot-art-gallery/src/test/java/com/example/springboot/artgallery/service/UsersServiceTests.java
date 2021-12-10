package com.example.springboot.artgallery.service;

import com.example.springboot.artgallery.dao.UsersRepository;
import com.example.springboot.artgallery.entity.Users;
import com.example.springboot.artgallery.exception.MyException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest
class UsersServiceTests {

    @Autowired
    private UsersService usersService;

    @MockBean
    private UsersRepository usersRepository;

    @Test
    void findByUsername_getUserWithEmail() {
        Users users = new Users("jack@artist.com", "abcdef12345", (short) 1);
        Optional<Users> userByEmail = Optional.of(users);
        when(usersRepository.findByUsername("jack@artist.com")).thenReturn(userByEmail);
        assertEquals(usersService.findByUsername("jack@artist.com"),users);
    }

    @Test
    void findByUsername_exceptionTest() {
        Exception exception = assertThrows(MyException.class, () -> usersService.findByUsername("jack@artist.com"));
        String expectedMessage = "Did not find User - jack@artist.com";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage,actualMessage);
    }


    @Test
    void save_saveUser() {
        Users users = new Users("jack@artist.com", "abcdef12345", (short) 1);
        usersService.save(users);
        verify(usersRepository,times(1)).save(users);
    }

    @Test
    void delete_deleteUserWithId() {
        usersService.deleteByUsername("jack@artist.com");
        verify(usersRepository,times(1)).deleteByUsername("jack@artist.com");
    }
}
