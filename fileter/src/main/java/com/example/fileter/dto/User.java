package com.example.fileter.dto;

import lombok.*;

@Data  // getter, setter, toString, hashCode 까지 다 관리해줌
@NoArgsConstructor   // 기본 생성자
@AllArgsConstructor  // 전체 생성자
public class User {

    private String name;

    private int age;
}
