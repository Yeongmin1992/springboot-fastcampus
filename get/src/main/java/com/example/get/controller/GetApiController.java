package com.example.get.controller;

import com.example.get.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping(path = "/hello") // http://localhost:9090/api/get/hello
    public String hello() {
        return "get hello";
    }


    @RequestMapping(path = "/hi", method = RequestMethod.GET) // 메소드 지정 안해주면 get/ pust / put / delete 모든 메서드 맵핑됨
    public String hi() {
        return "hi";
    }

    // http://localhost:9090/api/get/path-variable
    @GetMapping("/path-variable/{name}") // @PathVariable에는 원래 파라미터와 이름을 같게 해줘야 하지만 아래처럼 하면 이름을 다르게 지정 가능
    public String pathVariable(@PathVariable(name = "name") String Pathname) {
        System.out.println("PathVariable : "+Pathname);

        return Pathname;
    }

    // http://localhost:9090/api/get/query-param?user=steve&email=setve@gmail.com&age=30
    @GetMapping(path = "query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam) {
        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach(entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey()+" = "+entry.getValue()+"\n");
        });

        return sb.toString();
    }

    @GetMapping("query-param02")
    public String queryParam02(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ){

        System.out.println(name);
        System.out.println(email);
        System.out.println(age);

        return name+" "+email+" "+age;

    }

    //?user=steve&email=setve@gmail.com&age=30 스프링 부트가 URI 이름과 도메인 변수를 맵핑해줌
    @GetMapping("query-param03")
    public String queryParam03(UserRequest userRequest)
    {

        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();

    }


}
