package com.gcc.coreapi.books;

import com.gcc.coreapi.books.models.Book;
import com.gcc.coreapi.books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class BooksController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/books")
    ResponseEntity getBooks() {
        Iterable<Book> all = bookRepository.findAll();
        List<Book> allBooks = (List<Book>) all;
        return ResponseEntity.ok(allBooks);
    }

    @GetMapping("/books/{id}")
    ResponseEntity getBooksById(@PathVariable String id) {
        Long idx = Long.parseLong(id);
        Optional<Book> byId = bookRepository.findById(idx);
        return byId.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @PostMapping("/books")
    ResponseEntity newBook() {
        return ResponseEntity.ok("under development");
    }
}
