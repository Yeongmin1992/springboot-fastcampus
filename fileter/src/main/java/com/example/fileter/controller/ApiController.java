package com.example.fileter.controller;

import com.example.fileter.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j  // lombok 사용시 java로 로그를 system out으로 찍는게 아니라 log 변수를 사용하여 찍을 수 있음
@RestController
@RequestMapping("/api/user")
public class ApiController {

    @PostMapping("")
    public User user(@RequestBody User user) {
        // log.info("User : {}, {}, user, user");  이런식으로 사용하면 첫 번째 객체의 toString이 첫 번째 중괄호 안에, 두 번째 객체의 toString이 두 번째 중괄호 안에 담겨 로그를 찍을 수 있다.
        log.info("User : {}", user);
        return user;
    }
}
