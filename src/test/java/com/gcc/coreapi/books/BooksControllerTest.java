package com.gcc.coreapi.books;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BooksControllerTest {

    @Autowired
    private BooksController booksController;

    @Test
    void shouldReturnListOfBooks() {
        assertThat(booksController).isNotNull();
        assertThat(booksController.getBooks().getStatusCode()).isEqualTo(HttpStatus.OK);
    }

}