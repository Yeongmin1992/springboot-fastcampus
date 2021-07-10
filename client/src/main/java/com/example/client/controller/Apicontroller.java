package com.example.client.controller;

import com.example.client.dto.Req;
import com.example.client.dto.UserResponse;
import com.example.client.service.RestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client")
public class Apicontroller {

    private final RestTemplateService restTemplateService;

    public Apicontroller(RestTemplateService restTemplateService) {
        this.restTemplateService = restTemplateService;
    }

    @GetMapping("/hello")
    public Req<UserResponse> getHello() {
        // get 방식 호출 할 때
        // return restTemplateService.hello();
        // post 방식 호출 할 때
        // return restTemplateService.post();
        //return new UserResponse();

        // 헤더 추가
        return restTemplateService.genericExchange();
    }
}
