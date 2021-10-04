package com.fastcampus.jpa.bookmanager.domain;

import com.fastcampus.jpa.bookmanager.domain.listener.Auditable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
@ToString(callSuper = true)   // BaseEntity를 상속받은 변수가 @Data가 적용이 안 되어 toString 재정의
@EqualsAndHashCode(callSuper = true)    // BaseEntity를 상속받은 변수가 @Data가 적용이 안 되어 hash code 재정의 -> 상속 받는 코드 까지 toString을 적용하고, equal hash code를 적용 하겠다.
// @EntityListeners(value = AuditingEntityListener.class)
// @EntityListeners(value = MyEntityListner.class)
// public class UserHistory extends BaseEntity implements Auditable {
public class UserHistory extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    private Long userId;

    private String name;

    private String email;

//    @CreatedDate
//    private LocalDateTime createdAt;

//    @LastModifiedDate
//    private LocalDateTime updatedAt;
}
