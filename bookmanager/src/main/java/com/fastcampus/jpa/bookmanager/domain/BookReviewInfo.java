package com.fastcampus.jpa.bookmanager.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BookReviewInfo extends BaseEntity{
    @Id
    @GeneratedValue
    private Long id;

    private Long bookId;

    //아래는 primitive(float) type -> primitive type은 기본값 0, wrappered(Float) type은 null 허용 안함
    private float averageReviewScore;

    //아래는 primitive(int) type -> primitive type은 기본값 0, wrappered(Integer) type은 null 허용 안함
    private int reviewCount;
}
