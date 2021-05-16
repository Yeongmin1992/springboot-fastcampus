package com.example.aop.controller;


import com.example.aop.annotation.Decode;
import com.example.aop.annotation.Timer;
import com.example.aop.dto.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping("/get/{id}")
    public String get(@PathVariable Long id, @RequestParam String name){
        return id + " " + name;
    }


    @PostMapping("/post")
    public User post(@RequestBody User user) {
        System.out.println("post mehthod : " + user);
        return user;
    }

    @Timer
    @DeleteMapping("/delete")
    public void delete() throws InterruptedException {

        /*
        aop를 지원하지 않는다면 짜야할 코드(필요한 곳에 일일이 다 넣어줘야 함)
        StopWatch stopwatch = new StopWatch();
        stopWatch.start();
         */

        // db logic
        Thread.sleep(1000 * 2);

        /*
        aop를 지원하지 않는다면 짜야할 코드
        stopWatch.stop();
        System.out.println("total time : " + stopWatch.getTotalTimeSeconds());
         */
    }

    @Decode
    @PutMapping("/put")
    public User put(@RequestBody User user) {
        System.out.println("put");
        System.out.println(user);
        return user;
    }
}
