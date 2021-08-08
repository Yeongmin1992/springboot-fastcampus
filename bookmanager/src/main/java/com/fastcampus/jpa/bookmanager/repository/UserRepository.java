package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

// 제네릭 타입에는 생성한 도메인 타입과, PK의 타입을 넣어준다
public interface UserRepository extends JpaRepository<User, Long> {
    // 쿼리메소드 -> 결과 값이 여러개일 경우 List로 받으면 된다.
    // List<User> findByName(String name);

    //findById와 같은 Optional 객체로 받을 수 있을까? -> 잘 받는다
    // Optional<User> findByName(String name);

   // Set도 잘 받는다
   // 아래 넷은 모두 같은 구문 -> findBy 사이의 객체명 생략 가능, is 와 equals 생략 가능
   Set<User> findByName(String name);
   Set<User> findUserByName(String name);
   Set<User> findUserByNameIs(String name);
   Set<User> findUserByNameEquals(String name);

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

   List<User> findByEmailAndName(String email, String name);

   List<User> findByEmailOrName(String email, String name);

   List<User> findByCreatedAtAfter(LocalDateTime yesterday);

   List<User> findByIdAfter(Long id);

   // After or Before 보다 Greater or Less가 숫자 날짜에 모두 사용할 수 있어, 더 범용적으로 쓰임 -> 해당 값은 포함하지 않고 크거나 작은 값
   List<User> findByCreatedAtGreaterThan(LocalDateTime yesterday);

   List<User> findByCreatedAtGreaterThanEqual(LocalDateTime yesterday);

   List<User> findByCreatedAtBetween(LocalDateTime yesterday, LocalDateTime tomorrow);

   // beteween의 경우 인자로 들어온 시작과 끝도 포함!!
   List<User> findByIdBetween(Long id1, Long id2);

   // between과 동일한 쿼리문
   List<User> findByIdGreaterThanEqualAndIdLessThanEqual(Long id1, Long id2);

   List<User> findByIdIsNotNull();

   // Empty는 collection type에만 적용 가능, String 안됨
   // adress is not null and address != '' 의 의미가 아님 -> 잘 사용 안함
//   List<User> findByAddressIsNotEmpty();

   List<User> findByNameIn(List<String> names);

   List<User> findByNameStartingWith(String name);

   List<User> findByNameEndingWith(String name);

   List<User> findByNameContains(String name);

   List<User> findByNameLike(String name);

   // 1은 생략 가능
   List<User> findTop1ByNameOrderByIdDesc(String Name);

   // id 내림차순, email 오름차순순 -> where 조건은 and를 붙여서 이어주지만 order by 조건은 단순 나열
  List<User> findFirstByNameOrderByIdDescEmailAsc(String name);

  List<User> findFirstByName(String Name, Sort sort);

  Page<User> findByName(String name, Pageable pageable);

}
