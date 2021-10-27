package com.fastcampus.jpa.bookmanager.domain;

import com.fastcampus.jpa.bookmanager.domain.listener.Auditable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor // Entity객체는 기본생성자 필수
@Data
@ToString(callSuper = true)   // BaseEntity를 상속받은 변수가 @Data가 적용이 안 되어 toString 재정의
@EqualsAndHashCode(callSuper = true)    // BaseEntity를 상속받은 변수가 @Data가 적용이 안 되어 hash code 재정의 -> 상속 받는 코드 까지 toString을 적용하고, equal hash code를 적용 하겠다.
// @EntityListeners(value = AuditingEntityListener.class)
// @EntityListeners(value = MyEntityListner.class)
// public class Book extends BaseEntity implements Auditable {
public class Book extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 괄호안에 값을 안넣으면 만들어진 값을 가져다 쓰겠다? -> 여기서는 h2 db여서 hibernate sequence로 만들어진 값
    private Long id;

    private String name;

    private String category;

    private Long authorId;

    private Long publisherId;

    // optional을 false로 하면 book_id가 not null이 되고, book과의 join이 left outer join에서 inner join으로 변경 됨
    // mappedBy를 사용하면 연관키를 더 이상 해당 테이블에서 가지지 않게 됨(BookReviewInfo 테이블에서 Book id가 빠지지만 양쪽으로 관계를 걸어서 원하는 데이터를 볼 수 있음)
    @OneToOne(mappedBy = "book")
    // etity relation을 사용하는 경우 toString()과 같은 메서드가 순환참조가 걸리게 됨. 따라서, relation을 단방향으로 걸거나 toString()에서 제외하는 것이 필요하다.
    @ToString.Exclude
    private BookReviewInfo bookReviewInfo;

//    @CreatedDate
//    private LocalDateTime createdAt;

//    @LastModifiedDate
//    private LocalDateTime updatedAt;

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
