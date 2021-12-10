package com.example.springboot.artgallery.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class UsersTests {

    @Test
    void usersUsername_Test() {
        Users users = new Users();
        users.setUsername("jack@artist.com");
        assertEquals("jack@artist.com", users.getUsername());
    }

    @Test
    void password_Test() {
        Users users = new Users();
        users.setPassword("abcdef12345");
        assertEquals("abcdef12345", users.getPassword());
    }

    @Test
    void enabled_Test() {
        Users users = new Users();
        users.setEnabled((short) 1);
        assertEquals(1, users.getEnabled());
    }

    @Test
    void userAuthority_Test() {
        Users users=new Users();
        Authorities authority1 = new Authorities("jack@artist.com","ROLE_ARTIST");
        Authorities authority2 = new Authorities("jack@artist.com","ROLE_ARTIST");
        List<Authorities> authorities = new ArrayList<>();
        authorities.add(authority1);
        users.setAuthorities(authorities);
        users.addAuthority(authority2);
        assertEquals(2,users.getAuthorities().size());
    }

    @Test
    void addAuthorityUsers_Test() {
        Users users = new Users("jack@artist.com", "abcdef12345", (short) 1);
        Authorities authority = new Authorities("jack@artist.com","ROLE_ARTIST");
        users.addAuthority(authority);
        assertEquals(1,users.getAuthorities().size());
    }

    @Test
    void toStringUsers_ConvertsToString() {
        assertFalse(new Users().toString().contains("@$"));
    }
}
