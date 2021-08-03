package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void crud() {

        // getOne은 session 오류로 인하여 @Transactional 어노테이션이 필요함, 현재는 사용 안하는 듯
        // getOne은 기본적으로 Entity 에 대하여 lazy한 로딩을 지원. lazy patch는 추후에 다룰 예정
        // User user = userRepository.getOne(1L);
        // findById는 결과값을 Optional 객체로 랩핑하여 줌
        // Optional<User> user = userRepository.findById(1L);
        // orElse를 활용하여 해당 id가 없을 때 null 반환하도록 가능. orElse 사용시에는 Otional이 아니어도 됨
        User user = userRepository.findById(1L).orElse(null);

        System.out.println(user);

/*
        User user1 = new User("jack", "jack@gmail.com");
        User user2 = new User("steve", "steve@gmail.com");

        // 넣어준 요소 수만큼 insert 함
        userRepository.saveAll(Lists.newArrayList(user1, user2));

        List<User> users = userRepository.findAll();

        users.forEach(System.out::println);
        */

/*
        // 이름으로 내림차순 정렬
        List<User> users = userRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));

        List<Long> ids = new ArrayList<>();
        ids.adds(1L);
        ids.adds(3L);
        ids.adds(5L);
        아래 코드는 이와 동일(테스트에서만 제공하는 코드)
        List<User> users = userRepository.findAllById(ids);
        L은 숫자가 long 타입이라는 것을 지정해 줌
         *//*


        // 1,3,5번만 뽑기
        List<User> users = userRepository.findAllById(Lists.newArrayList(1L, 3L, 5L));

        users.forEach(System.out::println);


        // 기본생성자를 호출하고 테이블에 저장하겠다.
        userRepository.save(new User());

        // User테이블의 모든 데이터를 리스트형식으로 가져오기(stream, lamda식 더 살펴 볼 것)
        userRepository.findAll().forEach(System.out::println);
*/


    }
}