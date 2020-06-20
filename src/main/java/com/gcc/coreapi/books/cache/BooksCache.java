package com.gcc.coreapi.books.cache;

import com.gcc.coreapi.books.models.Book;
import com.gcc.coreapi.books.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class BooksCache {

    @Autowired
    private BookRepository bookRepository;

    @Cacheable(cacheNames = "myBookQuery")
    public String cacheQueryResult() {
        log.info("returning result NOT from cache");
        return "this is it";
    }

    @Cacheable(cacheNames = "allBooks")
    public List<Book> allBooks() {
        log.info("caching all books");
        return (List<Book>) bookRepository.findAll();
    }
}
