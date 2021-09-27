package com.fastcampus.jpa.bookmanager.domain;

import com.fastcampus.jpa.bookmanager.domain.listener.Auditable;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor // Entity객체는 기본생성자 필수
@Data
@EntityListeners(value = AuditingEntityListener.class)
// @EntityListeners(value = MyEntityListner.class)
public class Book implements Auditable {
    @Id
    @GeneratedValue // 만들어진 값을 가져다 쓰겠다? -> 여기서는 h2 db여서 hibernate sequence로 만들어진 값
    private Long id;

    private String name;

    private String author;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

/*  Entity Listner로 처리 가능
    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
    */
}
