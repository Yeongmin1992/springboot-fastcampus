package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

// 제네릭 타입에는 생성한 도메인 타입과, PK의 타입을 넣어준다
public interface UserRepository extends JpaRepository<User, Long> {
}
