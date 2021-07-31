package com.fastcampus.jpa.bookmanager.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    void test() {
        User user = new User();
        user.setEmail("hello@gmail.com");
        user.setName("hello");

        User user2 = User.builder()
                .name("hello")
                .email("hello@gmail.com")
                .build();

        System.out.println(">>>" + user);
    }

}