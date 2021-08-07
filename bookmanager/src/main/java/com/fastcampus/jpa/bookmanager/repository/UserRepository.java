package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

// 제네릭 타입에는 생성한 도메인 타입과, PK의 타입을 넣어준다
public interface UserRepository extends JpaRepository<User, Long> {
    // 쿼리메소드 -> 결과 값이 여러개일 경우 List로 받으면 된다.
    // List<User> findByName(String name);

    //findById와 같은 Optional 객체로 받을 수 있을까? -> 잘 받는다
    // Optional<User> findByName(String name);

    // Set도 잘 받는다다
   Set<User> findByName(String name);

   // 아래는 모두 같은 조회 결과값을 가져온다.
   // 여기서
   User findByEmail(String email);

   User getByEmail(String email);

   User readByEmail(String email);

   User queryByEmail(String email);

   User searchByEmail(String email);

   User streamByEmail(String email);

   // 보통 생략하지만 find와 By 사이에 사용하는 객체명을 넣을 수 있다.
   User findUserByEmail(String email);

   // 전혀 다른 객체명을 넣는 다면? -> 돌아간다. find와 By 사이의 String은 무시됨을 알 수 있음. 그래서 주의가 필요(컴파일시가 아닌 runtime 에러가 발생하기 때문)
   User findSomethingByEmail(String email);

   // 여기 까지

   List<User> findFirst2ByName(String name);

   List<User> findTop2ByName(String name);

   // 지정되지 않은 쿼리메소드는 findBy로 대체하여 실행한다.
   List<User> findLast1ByName(String name);

}
