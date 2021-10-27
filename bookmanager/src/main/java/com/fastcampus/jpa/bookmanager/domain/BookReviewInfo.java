package com.fastcampus.jpa.bookmanager.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BookReviewInfo extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private Long bookId;

    // optional을 false로 하면 book_id가 not null이 되고, book과의 join이 left outer join에서 inner join으로 변경 됨
    // mappedBy를 사용하면 연관키를 더 이상 해당 테이블에서 가지지 않게 됨(BookReviewInfo 테이블에서 Book id가 빠짐)
    @OneToOne(optional = false)
    private Book book;

    //아래는 primitive(float) type -> primitive type은 기본값 0, wrappered(Float) type은 null 허용 안함
    private float averageReviewScore;

    //아래는 primitive(int) type -> primitive type은 기본값 0, wrappered(Integer) type은 null 허용 안함
    private int reviewCount;
}
