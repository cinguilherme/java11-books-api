package com.gcc.coreapi.books;

import com.gcc.coreapi.books.models.Book;
import com.gcc.coreapi.books.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@Slf4j
public class BooksController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/books")
    ResponseEntity getBooks() {

        Iterable<Book> all = bookRepository.findAll();
        List<Book> allBooks = (List<Book>) all;
        return ResponseEntity.ok(allBooks);
    }

    @Cacheable(value = "single-book", key = "#id")
    @GetMapping("/books/{id}")
    ResponseEntity getBooksById(@PathVariable String id) {
        try {
            final long idx = Long.parseLong(id);
            Optional<Book> byId = bookRepository.findById(idx);
            return byId.map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (RuntimeException rte) {
            Map<String, String> body = new HashMap<>();
            body.put("message", "id path has to be a number");
            return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/books")
    ResponseEntity newBook(@RequestBody Book newBook) {
        log.info("taking in a new book {}", newBook.toString());
        Book save = bookRepository.save(newBook);
        return ResponseEntity.ok(save);
    }
}
