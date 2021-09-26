package com.fastcampus.jpa.bookmanager.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor  // 변수에 아무 어노테이션을 달아주지 않으면 @NoArgsConstructor와 같이 기본 생성자 생성. 롬복의 @NonNull이 붙은 변수가 있으면 해당 변수를 가진 생성자 생성 @Data가 기본적으로 제공하는 어노테이션
@Data  // 눌러보면 어떤 어노테이션들을 대체하는지 나옴
@Builder  // AllArgsConstuctor와 비슷하게 객체를 생성하고, 필드값을 주입하여 주는데, builder의 형식으로 작동함
@Entity  // 테이블 객체로 만들기
@EntityListeners(value = {MyEntityListner.class, UserEntityListener.class})
//@Table(name = "user", indexes = {@Index(columnList = "name")}, uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})  // name은 설정해주지 않으면 클래스 이름으로 생성.(db와 동일하게 하는 것이 좋다.) index 와 uniquConstraints 설정은 db에 맡기고 객체에는 잘 달아주지 않는 경우가 많음
public class User implements Auditable {
    @Id   // primary key
    @GeneratedValue() // 자동 증가 -> 현재는 db에 자동 증가를 위임하기 위해 괄호 안의 내용 작성해 줌
    private Long id;

    @NonNull
    private String name;

    @NonNull
    // @Column(unique = true) -> 위의 @Table에서 uniqueConstraint로 걸어준 것은 name열과 함께 엮어서 사용하기 위함이고, 특정 컬럼만 따로 유니크 설정 가능
    private String email;

    // default가 ordinal로 되어있어, Enum클래스에서 순차적으로 변수 위치에 0,1,2 ... 가 할당 됨 -> 자주 버그를 생성하기 때문에, enum을 사용할 경우에는 반드시 enumType을 String으로 할 것
    @Enumerated(value = EnumType.STRING)
    private Gender gender;

//    @Column(nullable = false) // 테이블의 각 열을 설정해주는 어노테이션
    @Column(updatable = false)  // @Column의 다른 애들과 다르게 ddl, dml모두에 적용됨
    private LocalDateTime createdAt;

//    @Column(insertable = false) -> @Column의 다른 애들과 다르게 ddl, dml모두에 적용됨
    private LocalDateTime updatedAt;

    // User 클레스는 db의 데이터와 맵핑하는 역할도 하지만, @Transient를 활용하여 객체로써 db 이외의 값을 가질수도 있음 -> 영속성을 갖지 않고, db가 아닌 객체와 생명주기를 함께 함
    @Transient
    private String testData;

//    @OneToMany(fetch = FetchType.EAGER)
//    private List<Address> address;


    // JPA 핸들러러

    // insert 메서드가 실행되기 이전에 호출 -> createdAt, UpdatedAt과 같은 데이터를 반복적으로 실행되도록 할 때 사용할 수 있다!! -> Entity Listener로 처리 가능
//    @PrePersist
//    public void prePersist() {
//        this.createdAt = LocalDateTime.now();
//        this.updatedAt = LocalDateTime.now();
//    }

    // insert 메서드가 실행된 이후에 호출
    @PostPersist
    public void postPersist() {
        System.out.println(">>> postPersist");
    }

    // merge 메서드가 실행되기 이전에 호출 -> entity listener로 처리 가능
//    @PreUpdate
//    public void preUpdate() {
//        this.updatedAt = LocalDateTime.now();
//    }

    // merge 메서드가 실행된 이후에 호출
    @PostUpdate
    public void postUpdate() {
        System.out.println(">>> postUpdate");
    }

    // delete 메서드가 실행되기 이전에 호출
    @PreRemove
    public void preRemove() {
        System.out.println(">>> preRemove");
    }

    // delete 메서드가 실행되기 이후에 호출
    @PostRemove
    public void postRemove() {
        System.out.println(">>> postRemove");
    }

    // select 메서드가 실행된 이후에 호출
    @PostLoad
    public void postLoad() {
        System.out.println(">>> postLoad");
    }
}