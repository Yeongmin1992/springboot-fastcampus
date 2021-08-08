package com.fastcampus.jpa.bookmanager.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor  // 변수에 아무 어노테이션을 달아주지 않으면 @NoArgsConstructor와 같이 기본 생성자 생성. 롬복의 @NonNull이 붙은 변수가 있으면 해당 변수를 가진 생성자 생성 @Data가 기본적으로 제공하는 어노테이션
@Data  // 눌러보면 어떤 어노테이션들을 대체하는지 나옴
@Builder  // AllArgsConstuctor와 비슷하게 객체를 생성하고, 필드값을 주입하여 주는데, builder의 형식으로 작동함
@Entity  // 테이블 객체로 만들기
public class User {
    @Id   // primary key
    @GeneratedValue() // 자동 증가 -> 현재는 db에 자동 증가를 위임하기 위해 괄호 안의 내용 작성해 줌
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

//    @OneToMany(fetch = FetchType.EAGER)
//    private List<Address> address;
}

