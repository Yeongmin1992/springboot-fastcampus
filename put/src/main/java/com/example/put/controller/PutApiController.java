package com.example.put.controller;

import com.example.put.dto.PostRequestDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PutApiController {

    @PutMapping("/put/{userId}")
    public PostRequestDto put(@RequestBody PostRequestDto requestDto, @PathVariable(name = "userId") Long id) {
        System.out.println(requestDto);
        return requestDto;

    }
}

/*
{
    "name": "steve",
    "age": 20,
    "car_list":[
        {
            "name": "BMW",
            "car_number": "11가 1234"
        },
        {
            "name": "A4",
            "car_number": "22가 3456"
        }
    ]
}
 */