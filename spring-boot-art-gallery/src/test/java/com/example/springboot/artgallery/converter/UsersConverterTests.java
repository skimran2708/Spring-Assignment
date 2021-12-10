package com.example.springboot.artgallery.converter;

import com.example.springboot.artgallery.dto.UsersDto;
import com.example.springboot.artgallery.entity.Users;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UsersConverterTests {

    @Test
    void entityToDto_convertsUsersEntityToUsersDto() {
        Users users = new Users("jack@artist.com", "abcdef12345", (short) 1);
        UsersDto usersDto = new UsersConverter().entityToDto(users);
        assertEquals("jack@artist.com",usersDto.getUsername());
    }

    @Test
    void DtoToEntity_convertsUsersDtoToUsersEntity() {
        UsersDto usersDto = new UsersDto("jack@artist.com", "abcdef12345", (short) 1);
        Users users = new UsersConverter().dtoToEntity(usersDto);
        assertEquals("jack@artist.com",users.getUsername());
    }

    @Test
    void entityToDto_convertsUsersEntityListToUsersDtoList() {
        Users users1 = new Users("jack@artist.com", "abcdef12345", (short) 1);
        Users users2 = new Users("jack@artist.com", "abcdef12345", (short) 1);
        List<Users> usersList = new ArrayList<>();
        usersList.add(users1);
        usersList.add(users2);
        List<UsersDto> usersDtoList = new UsersConverter().entityToDto(usersList);
        assertEquals(2,usersDtoList.size());
    }

    @Test
    void dtoToEntity_convertsUsersDtoListToUsersEntityList() {
        UsersDto usersDto1 = new UsersDto("jack@artist.com", "abcdef12345", (short) 1);
        UsersDto usersDto2 = new UsersDto("jack@artist.com", "abcdef12345", (short) 1);
        List<UsersDto> usersDtoList = new ArrayList<>();
        usersDtoList.add(usersDto1);
        usersDtoList.add(usersDto2);
        List<Users> usersList = new UsersConverter().dtoToEntity(usersDtoList);
        assertEquals(2,usersList.size());
    }
}
