package com.fastcampus.jpa.bookmanager.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor  // 변수에 아무 어노테이션을 달아주지 않으면 @NoArgsConstructor와 같이 기본 생성자 생성. 롬복의 @NonNull이 붙은 변수가 있으면 해당 변수를 가진 생성자 생성 @Data가 기본적으로 제공하는 어노테이션
@EqualsAndHashCode
@Data
@Builder  // AllArgsConstuctor와 비슷하게 객체를 생성하고, 필드값을 주입하여 주는데, builder의 형식으로 작동함
public class User {
    @NonNull
    public String name;
    @NonNull
    public String email;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

