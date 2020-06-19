package com.gcc.coreapi.books;

import com.gcc.coreapi.books.models.Book;
import com.gcc.coreapi.books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BooksController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/books")
    ResponseEntity getBooks() {
        List<Book> allBooks = bookRepository.findAll();
        return ResponseEntity.ok(allBooks);
    }


}
