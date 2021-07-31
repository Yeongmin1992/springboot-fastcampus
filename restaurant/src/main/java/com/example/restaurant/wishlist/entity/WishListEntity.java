package com.example.restaurant.wishlist.entity;

import com.example.restaurant.db.MemoryDbEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class WishListEntity extends MemoryDbEntity {

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
