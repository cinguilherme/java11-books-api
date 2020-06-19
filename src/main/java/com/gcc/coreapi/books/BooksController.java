package com.gcc.coreapi.books;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksController {

    @GetMapping("/books")
    ResponseEntity getBooks() {
        return ResponseEntity.ok("exists");
    }


}
