package com.example.restaurant.wishlist.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class WishListDto {

    // 인덱스
    private Integer index;

    // 음식명, 장소명
    private String title;

    // 카테고리
    private String category;

    // 주소
    private String address;

    // 도로명
    private String roadAddress;

    // 홈페이지 주소
    private String homePageLink;

    // 음식, 가게 이미지 주소
    private String imageLink;

    // 방문여부
    private boolean isVisit;

    // 방문 카운트
    private int visitCount;

    // 마지막 방문일자자
    private LocalDateTime lastVisitDate;
}
