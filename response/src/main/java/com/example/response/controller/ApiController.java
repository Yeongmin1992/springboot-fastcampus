package com.example.response.controller;

import com.example.response.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    //TEXT
    @GetMapping("/text")
    public String text(@RequestParam String account) {
        return account;
    }

    //Json
    //req -> object mapper -> object -> method -> object  -> opbject mapper -> json -> response
    @PostMapping("/json")
    public User json(@RequestBody User user) {
        return user; // 2000 ok

    }

    // ResponseEntity
    @PutMapping("/put")
    public ResponseEntity<User> put(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}

/*
{
    "name" : "steve",
    "age" : 10,
    "phoneNumber" : "010-1111-2222",
    "address" : "패스트캠퍼스"
}
 */
