/*
package com.example.exception.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// @RestControllerAdvice(basePackages = "com.example.exception.controller")과 같은 식으로 해당 패키지의 오류 처리 하기 가능
@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(value = Exception.class)   // Spring Application에서 발생하는 모든 에러를 다 잡겠다.
    public ResponseEntity exception(Exception e) {  // Exception e로 Exception.class라고 설정한 에러값을 받는다.
        System.out.println(e.getClass().getName());  // 어떤 에러인지 찍어보기
        System.out.println("-------------------------");
        System.out.println(e.getLocalizedMessage());
        System.out.println("-------------------------");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");   // 서버에서 발생하는 에러는 INTERNAL_SERVER_ERROR

    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

}

 */
