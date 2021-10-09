package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.Book;
import com.fastcampus.jpa.bookmanager.domain.BookReviewInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookReviewInfoRepositoryTest {
    @Autowired
    private BookReviewInfoRepository bookReviewInfoRepository;
    @Autowired
    private BookRepository bookRepository;

    @Test
    void crudTest() {
        BookReviewInfo bookReviewInfo = new BookReviewInfo();
//        bookReviewInfo.setBookId(1L);
        bookReviewInfo.setAverageReviewScore(4.5f);
        bookReviewInfo.setReviewCount(2);

        System.out.println(">>> " + bookReviewInfoRepository.findAll());
    }

    @Test
    void crudTest2() {
        givenBookReviewInfo();

        Book result = bookReviewInfoRepository
                    .findById(1L)
                    .orElseThrow(RuntimeException::new)
                    .getBook();

        System.out.println(">>> " + result);
    }

    private Book givenBook() {
        Book book = new Book();
        book.setName("Jpa 스터디");
        book.setAuthorId(1L);
        book.setPublisherId(1L);

        // entity save는 저장된 entity를 바로 return하도록 되어있다.
        return bookRepository.save(book);

    }

    private void givenBookReviewInfo() {
        BookReviewInfo bookReviewInfo = new BookReviewInfo();
        bookReviewInfo.setBook(givenBook());
        bookReviewInfo.setAverageReviewScore(4.5f);
        bookReviewInfo.setReviewCount(2);

        bookReviewInfoRepository.save(bookReviewInfo);

        System.out.println(">>> " + bookReviewInfoRepository.findAll());

    }

}