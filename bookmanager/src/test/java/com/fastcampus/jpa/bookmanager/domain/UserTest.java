package com.fastcampus.jpa.bookmanager.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    void test() {

        // @NoArgsConstructor 생성자의 역할
        User user = new User();
        user.setEmail("hello@gmail.com");
        user.setName("hello");

        // @AllArgsConstructor 생성자의 역할
        User user1 = new User(null, "hello", "hello@gmail.com", LocalDateTime.now(), LocalDateTime.now());
        // @AllArgsConstructor 생성자의 역할
        User user2 = new User("hello", "hello@gmail.com");



        User user3 = User.builder()
                .name("hello")
                .email("hello@gmail.com")
                .build();

        System.out.println(">>>" + user);
    }

}