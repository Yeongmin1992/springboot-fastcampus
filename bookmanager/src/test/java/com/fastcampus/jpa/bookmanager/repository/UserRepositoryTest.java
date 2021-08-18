package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.Gender;
import com.fastcampus.jpa.bookmanager.domain.User;
import org.assertj.core.util.Lists;
import org.hibernate.criterion.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.*;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void crud() {
       User user = new User();
       user.setEmail("daum");

       ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("email", contains());
       Example<User> example = Example.of(user, matcher);

        userRepository.findAll(example).forEach(System.out::println);
        /*
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("name")
                .withMatcher("email", endsWith());

        // Example.of에 인자로 들어가는 probe는 실제로 Entity는 아님을 나타냄(가찌 Entity로 볼 수 있다.)
        org.springframework.data.domain.Example<User> example = Example.of(new User("ma", "gmail.com"), matcher);
        userRepository.findAll(example).forEach(System.out::println);

        org.springframework.data.domain.Example<User> example = Example.of(new User("hello", "hello@gmail.com"));

        userRepository.findAll(example).forEach(System.out::println);


        // page는 0부터 시작
        Page<User> users = userRepository.findAll(PageRequest.of(1, 3));

        System.out.println("page : " + users);
        System.out.println("totalElements : " + users.getTotalElements());
        System.out.println("totalPages : " + users.getTotalPages());
        System.out.println("numberOfElements : " + users.getNumberOfElements());
        System.out.println("sort : " + users.getSort());
        // 페이징 할때 나누는 크기
        System.out.println("size : " + users.getSize());

        users.getContent().forEach(System.out::println);


        userRepository.deleteAllInBatch();
        // or 조건으로 delete문 한번 실행 -> SimpleJpaRepository를 보면 쿼리문을 만들어서 한번 실행하는 것을 볼 수 있음
      //  userRepository.deleteAllInBatch(userRepository.findAllById(Lists.newArrayList(1L, 3L)));

        // delete는 데이터 갯수만큼 delete문 실행 -> SimpleJpaRepository를 보면 for문을 돌려서 조회 및 삭제를 진행하는 것을 볼 수 있음
       // userRepository.deleteAll(userRepository.findAllById(Lists.newArrayList(1L, 3L)));

        // userRepository.deleteAll();
        // select문이 2번 돔
//        userRepository.delete(userRepository.findById(1L).orElseThrow(RuntimeException::new));

        // select문이 1번 돔
       // userRepository.deleteById(1L);

        userRepository.findAll().forEach(System.out::println);


        // 해당 id값이 있는지 없는지
        boolean exists = userRepository.existsById(1L);
        System.out.println(exists);

        // count는 long형식으로 리턴
//        long count = userRepository.count();

//        System.out.println(count);



//        userRepository.save(new User("new car", "newcar@gmail.com"));
          // flush는 db에 반영하는 시점을 조절하는 기능. 이후 영속성 다룰 때 자세히 다룰 예정
//        userRepository.flush();
        //위에 두줄 묶은 기능
        userRepository.saveAndFlush(new User("new car", "newcar@gmail.com"));

        userRepository.findAll().forEach(System.out::println);

        // getOne은 session 오류로 인하여 @Transactional 어노테이션이 필요함, 현재는 사용 안하는 듯
        // getOne은 기본적으로 Entity 에 대하여 lazy한 로딩을 지원. lazy patch는 추후에 다룰 예정
        // User user = userRepository.getOne(1L);
        // findById는 결과값을 Optional 객체로 랩핑하여 줌
        // Optional<User> user = userRepository.findById(1L);
        // orElse를 활용하여 해당 id가 없을 때 null 반환하도록 가능. orElse 사용시에는 Otional이 아니어도 됨
        User user = userRepository.findById(1L).orElse(null);

        System.out.println(user);


        User user1 = new User("jack", "jack@gmail.com");
        User user2 = new User("steve", "steve@gmail.com");

        // 넣어준 요소 수만큼 insert 함
        userRepository.saveAll(Lists.newArrayList(user1, user2));

        List<User> users = userRepository.findAll();

        users.forEach(System.out::println);



        // 이름으로 내림차순 정렬
        List<User> users = userRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));

        List<Long> ids = new ArrayList<>();
        ids.adds(1L);
        ids.adds(3L);
        ids.adds(5L);
        아래 코드는 이와 동일(테스트에서만 제공하는 코드)
        List<User> users = userRepository.findAllById(ids);
        L은 숫자가 long 타입이라는 것을 지정해 줌

        // 1,3,5번만 뽑기
        List<User> users = userRepository.findAllById(Lists.newArrayList(1L, 3L, 5L));

        users.forEach(System.out::println);


        // 기본생성자를 호출하고 테이블에 저장하겠다.
        userRepository.save(new User());

        // User테이블의 모든 데이터를 리스트형식으로 가져오기(stream, lamda식 더 살펴 볼 것)
        userRepository.findAll().forEach(System.out::println);

        // SimpleJpaRepository.class를 살펴보면 save함수가 상황에 따라 insert 혹은 update를 수행한다는 것을 알 수 있다.
        // ㄴ isNew 함수를 통해 해당 id가 null 이라면 insert, 존재하는 id라면 update를 실행

        userRepository.save(new User("david", "david@gmail.com"));

        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setEmail("hello-update@gmail.com");

        userRepository.save(user);
*/


    }

    @Test
    void select() {

//        System.out.println(userRepository.findByName("dennis"));
//
//        System.out.println("findByEmail : " + userRepository.findByEmail("hello@gmail.com"));
//        System.out.println("getByEmail : " + userRepository.getByEmail("hello@gmail.com"));
//        System.out.println("readByEmail : " + userRepository.readByEmail("hello@gmail.com"));
//        System.out.println("queryByEmail : " + userRepository.queryByEmail("hello@gmail.com"));
//        System.out.println("searchByEmail : " + userRepository.searchByEmail("hello@gmail.com"));
//        System.out.println("streamByEmail : " + userRepository.streamByEmail("hello@gmail.com"));
//        System.out.println("findUserByEmail : " + userRepository.findUserByEmail("hello@gmail.com"));
//        System.out.println("findSomethingByEmail : " + userRepository.findSomethingByEmail("hello@gmail.com"));
//
//        System.out.println("findTop2ByEmail : " + userRepository.findTop2ByName("hello"));
//        System.out.println("findFirst2ByEmail : " + userRepository.findFirst2ByName("hello"));
//        System.out.println("findLast1ByName : " + userRepository.findLast1ByName("hello"));

        System.out.println("findByEmailAndName : " + userRepository.findByEmailAndName("hello@gmail.com", "hello") );
        System.out.println("findByEmailOrName : " + userRepository.findByEmailOrName("hello@gmail.com", "dennis") );

        System.out.println("findByCreatedAtAfter : " + userRepository.findByCreatedAtAfter(LocalDateTime.now().minusDays(1L)));
        System.out.println("findByIdAfter : " + userRepository.findByIdAfter(4L));
        System.out.println("findByCreatedAtGreaterThan : " + userRepository.findByCreatedAtGreaterThan(LocalDateTime.now().minusDays(1)));
        System.out.println("findByCreatedAtGreaterThanEqual : " + userRepository.findByCreatedAtGreaterThanEqual(LocalDateTime.now().minusDays(1)));

        System.out.println("findByCreatedAtBetween : " + userRepository.findByCreatedAtBetween(LocalDateTime.now().minusDays(1L), LocalDateTime.now().plusDays(1L)));
        System.out.println("findByIdBetween : " + userRepository.findByIdBetween(1L, 3L));
        System.out.println("findByIdGreaterThanEqualAndIdLessThanEqual : " + userRepository.findByIdGreaterThanEqualAndIdLessThanEqual(1L, 3L));

        System.out.println("findByIdIsNotNull : " + userRepository.findByIdIsNotNull());
    //    System.out.println("findByAddressIsNotEmpty : " + userRepository.findByAddressIsNotEmpty());

        // lists로 list 생성하는 부분 참고! -> 실무에선 해당 부분에 다른 쿼리의 결과값이 들어가는 경우가 많음
        System.out.println("findByNameIn : " + userRepository.findByNameIn(Lists.newArrayList("hello", "dennis")));

        System.out.println("findByNameStartingWith : " + userRepository.findByNameStartingWith("hel"));
        System.out.println("findByNameEndingWith : " + userRepository.findByNameEndingWith("lo"));
        System.out.println("findByNameContains : " + userRepository.findByNameContains("ll"));

        // 위 세줄과 동일한 기능
        System.out.println("findByNameLike : " + userRepository.findByNameLike("hel%"));
        System.out.println("findByNameLike : " + userRepository.findByNameLike("%lo"));
        System.out.println("findByNameLike : " + userRepository.findByNameLike("%ll%"));
    }

    @Test
    void pagingAndSortingTest() {
        System.out.println("findTop1ByNameOrderByIdDesc : " + userRepository.findTop1ByNameOrderByIdDesc("hello"));
        System.out.println("findFirstByNameOrderByIdDescEmailAsc : " + userRepository.findFirstByNameOrderByIdDescEmailAsc("hello"));
        System.out.println("findFirstByNameWithSortParams : " + userRepository.findFirstByName("hello", Sort.by(Sort.Order.desc("id"), Sort.Order.asc("email"))));
        // 가독성을 위해 소팅 기준을 아래와 같이 함수로 선언해서 사용할 수 있다.
        System.out.println("findFirstByNameWithSortParams : " + userRepository.findFirstByName("hello", getSort()));
        System.out.println("findByNameWithPaging : " + userRepository.findByName("hello", PageRequest.of(0, 1, Sort.by(Sort.Order.desc("id")))).getContent());
        System.out.println("findByNameWithPaging : " + userRepository.findByName("hello", PageRequest.of(0, 1, Sort.by(Sort.Order.desc("id")))).getTotalElements());
    }

    // 가독성을 위해 소팅 기준을 아래와 같이 함수로 선언해서 사용할 수 있다.
    private Sort getSort() {
        return Sort.by(
                Sort.Order.desc("id"),
                Sort.Order.asc("email"),
                Sort.Order.desc("createdAt"),
                Sort.Order.asc("updatedAt")
        );
    }

    @Test
    void insertAndUdateTest() {
        User user = new User();
        user.setName("hello");
        user.setEmail("hello2@gmail.com");

        userRepository.save(user);

        User user2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user2.setName("helooooooo");

        userRepository.save(user2);
    }

    @Test
    void enumTest() {
        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setGender(Gender.MALE);

        userRepository.save(user);

        userRepository.findAll().forEach(System.out::println);

        System.out.println(userRepository.findRowRecord().get("gender"));

    }

    @Test
    void listenerTest() {
        User user = new User();
        user.setEmail("hello2@gmail.com");
        user.setName("hello");

        userRepository.save(user);

        User user2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user2.setName("helllllllo");

        userRepository.save(user2);

        userRepository.deleteById(4L);
    }

    @Test
    void prePersistTest() {
        User user = new User();
        user.setEmail("hello2@gmail.com");
        user.setName("hello");
        // prePersist로 처리
//        user.setCreatedAt(LocalDateTime.now());
//        user.setUpdatedAt(LocalDateTime.now());

        userRepository.save(user);

        System.out.println(userRepository.findByEmail("hello2@gmail.com"));
    }

    @Test
    void preUpdateTest() {
        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);

        System.out.println("as-is : " + user);

        user.setName("hello22");
        userRepository.save(user);

        // user값이 그대로 호출되는 것을 방지하기 위해 findAll()로 실제 db값을 조회하고, get(0)를 한다? -> 추후 영속성 관련해서 배울 것
        System.out.println("to-be : " + userRepository.findAll().get(0));
    }
}