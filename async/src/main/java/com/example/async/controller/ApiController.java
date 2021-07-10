package com.example.async.controller;

import com.example.async.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@Slf4j
@RestController
@RequestMapping("/api")
public class ApiController {

    private final AsyncService asyncService;

    public ApiController(AsyncService asyncService) {
        this.asyncService = asyncService;
    }

    /*
    @GetMapping("/hello")
    public String hello() {
        asyncService.hello();
        log.info("method end");
        return "hello";
    }

     */
    // CompletableFuter는 다른 스레드에서 실행시키고 난 후, 결과를 반환받는 형태
    // 한번에 여러개의 api request가 발생하고, 그 결과를 join해서 return할 때 많이 사용
    @GetMapping("/hello")
    public CompletableFuture hello() {
        log.info("completable future init");
        return asyncService.run();
    }
}
