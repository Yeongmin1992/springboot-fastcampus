package com.example.restaurant.db;

import java.util.List;
import java.util.Optional;

public interface MemoryDbRepositoryIfs<T> {

    // 인덱스에 해당하는 타입을 반환하는 메소드
    Optional<T> findById(int index);
    T save(T entity);
    void deleteById(int index);
    List<T> findAll();
}
