package com.example.client.service;

import com.example.client.dto.Req;
import com.example.client.dto.UserRequest;
import com.example.client.dto.UserResponse;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class RestTemplateService {

    // http://localhost/api/server/hello
    // get 방식 response
    public UserResponse hello() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/hello")
                .queryParam("name", "aaaa")
                .queryParam("age", 99)
                .encode()
                .build()
                .toUri();

        System.out.println(uri.toString());

        RestTemplate restTemplate = new RestTemplate();
        // client에서 http로 서버에 붙는 순간 getForObject가 실행 됨
        // getForObject는 어떤 타입으로 지정해줄지 선택 가능 api에서 무엇을 리턴하는지 모를 때 단순히 스트링으로 해서 찍어본다.
        // String result = restTemplate.getForObject(uri, String.class);
        // UserResponse result = restTemplate.getForObject(uri, UserResponse.class);

        // getForResponse는 헤더 내용등을 포함한 response형식으로 받는다 (더 정확한 방식)
        // ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

        ResponseEntity<UserResponse> result = restTemplate.getForEntity(uri, UserResponse.class);

        System.out.println(result.getStatusCode());
        System.out.println(result.getBody());

       return result.getBody();
    }

    public UserResponse post() {
        // http://localhost:9090/api/server/user/{userId}/name/{UserName} expand로 uri에 변수를 넣을 수 있음을 보여지기 위한 예제, 실제 이렇게 사용은 안함

        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/user/{userId}/name/{userName}")
                .encode()
                .build()
                .expand(100, "steve")
                .toUri();
        System.out.println(uri);

        // http body -> object -> object mapper -> json -> rest template -> http body json
        UserRequest req = new UserRequest();
        req.setName("steve");
        req.setAge(10);

        RestTemplate restTemplate = new RestTemplate();
        // 서버가 어떻게 응답할지 모를 경우에는 UserResponse가 아닌 단순히 String으로 받아 볼 수도 있다.
        ResponseEntity<UserResponse> response = restTemplate.postForEntity(uri, req, UserResponse.class);

        System.out.println(response.getStatusCode());
        System.out.println(response.getHeaders());
        System.out.println(response.getBody());

        return response.getBody();

    }

    // 헤더에 athorization 키와 같은 내용 담기
    /*
    {
       "header" : {
            "response_code" : ""
       },
       "body" : {
            "name" : "spring boot",
            "age" : 1024
       }
    }
    와 같은 형식으로 body의 내용만 계속 바뀔 때때
    */
    public UserResponse exchange() {

        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/user/{userId}/name/{userName}")
                .encode()
                .build()
                .expand(100, "steve")
                .toUri();
        System.out.println(uri);

        // http body -> object -> object mapper -> json -> rest template -> http body json
        UserRequest req = new UserRequest();
        req.setName("steve");
        req.setAge(10);

        RequestEntity<UserRequest> requestEntity = RequestEntity
                .post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .header("x-authorization", "abcd")
                .header("custom-header", "fffff")
                .body(req);


        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserResponse> response = restTemplate.exchange(requestEntity, UserResponse.class);
        return response.getBody();
    }

    public Req<UserResponse> genericExchange() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/user/{userId}/name/{userName}")
                .encode()
                .build()
                .expand(100, "steve")
                .toUri();
        System.out.println(uri);

        // http body -> object -> object mapper -> json -> rest template -> http body json

        UserRequest userRequest = new UserRequest();
        userRequest.setName("steve");
        userRequest.setAge(10);

        Req<UserRequest> req = new Req<UserRequest>();
        req.setHeader(
                new Req.Header()
        );

        req.setResBody(
                userRequest
        );



        RequestEntity<Req<UserRequest>> requestEntity = RequestEntity
                .post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .header("x-authorization", "abcd")
                .header("custom-header", "fffff")
                .body(req);

        RestTemplate restTemplate = new RestTemplate();


        // 제네릭에는 클래스를 붙일 수 없다
        ResponseEntity<Req<UserResponse>> response = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<Req<UserResponse>>(){});

        // 첫 번째 getBody는 req의 response를 받고, 그 안에 들어있는 response entity를 받음
        //return response.getBody().getResBody();
        return response.getBody();

    }

    // Request, Header 객체 없이 Object type(어떤 응답이 올지 잘 모를 경우)
    public ResponseEntity<Object> post2() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/user/{userId}/name/{userName}")
                .encode()
                .build()
                .expand(100, "steve")
                .toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.set("x-authorization", "abcd");
        headers.set("custom-header", "fffff");

        MultiValueMap<String, String> userBody = new LinkedMultiValueMap<>();
        userBody.add("name", "King");
        userBody.add("age", "20");
        HttpEntity<Object> httpEntity = new HttpEntity<>(userBody, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> result = restTemplate.postForEntity(uri, httpEntity, Object.class);

        return result;
    }
}
