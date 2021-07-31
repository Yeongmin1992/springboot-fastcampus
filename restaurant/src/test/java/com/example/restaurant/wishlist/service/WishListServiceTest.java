package com.example.restaurant.wishlist.service;

import com.example.restaurant.wishlist.sevice.WishListService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WishListServiceTest {

    @Autowired
    private WishListService wishListService;

    // 원래는 search를 바로 test하는 것이 아닌 WishListService가 DI로 의존성을 주입 받은 NaverClient를 Mocking하여 어떤 값을 내려준다고 만들어둔 후에 비교해야함
    @Test
    public void searchTest() {
        var result = wishListService.search("갈비집");
        System.out.println(result);
        Assertions.assertNotNull(result);
    }
}
